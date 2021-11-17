package net.siegerpg.siege.core.parties

import co.aikar.commands.BaseCommand
import co.aikar.commands.CommandCompletions
import co.aikar.commands.annotation.*
import co.aikar.commands.bukkit.contexts.OnlinePlayer
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.Template
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.entity.Player

@CommandAlias("party|p")
class PartyCommand : BaseCommand() {

	init {
		Core.plugin().commandManager.commandCompletions.registerCompletion(
				"partymembers",
				CommandCompletions.CommandCompletionHandler { player ->
					val party = Party.getPlayerParty(player.player)
					            ?: return@CommandCompletionHandler listOf<String>()
					return@CommandCompletionHandler party.getMembers().map { p -> p.name }
				})
	}

	@Subcommand("create|c|new")
	fun createParty(player : Player) {
		val party = Party.getPlayerParty(player)
		if (party != null) {
			player.sendMessage(Utils.tacc("&7You are already in a party!"))
			return
		}
		Party(player)
		player.sendMessage(Utils.tacc("&7Successfully created a party!"))
	}

	@Subcommand("join|j|accept")
	@Syntax("[inviter]")
	@CommandCompletion("@players")
	fun joinParty(player : Player, @Optional inviter : OnlinePlayer?) {
		val playerInvites = Party.getPlayerInvites(player)
		if (playerInvites.size == 0) {
			player.sendMessage(Utils.tacc("&7You haven't been invited to any parties!"))
			return
		} else if (playerInvites.size >= 1) {
			if (inviter != null) {
				val inviterParty = Party.getPlayerParty(inviter.player)
				if (inviterParty == null) {
					player.sendMessage(Utils.tacc("&cThat user isn't in a party!"))
					return
				}
				val partyInCommon = playerInvites[inviterParty.partyID]
				if (partyInCommon == null) {
					player.sendMessage(Utils.tacc("&cYou weren't invited to that party!"))
					return
				}
				partyInCommon.removeInvite(player)
				partyInCommon.send(Utils.tacc("&6${player.name}&7 just joined the party!"))
				partyInCommon.addMember(player)
				player.sendMessage(Utils.tacc("&7You have successfully joined &6${partyInCommon.getLeader().name}&7's party!"))
			} else {
				val party = playerInvites[playerInvites.keys.first()]!!
				party.removeInvite(player)
				party.send(Utils.tacc("&6${player.name}&7 just joined the party!"))
				party.addMember(player)
				player.sendMessage(Utils.tacc("&7You have successfully joined &6${party.getLeader().name}&7's party!"))
			}
		}
	}

	@Subcommand("leave|disband")
	fun leaveParty(player : Player) {
		val party = Party.getPlayerParty(player)
		if (party == null) {
			player.sendMessage(Utils.tacc("&cYou are not currently in a party!"))
			return
		}
		party.leave(player)
	}

	@Subcommand("kick|remove")
	@Syntax("<player>")
	@CommandCompletion("@partymembers")
	fun kickFromParty(player : Player, playerToKick : OnlinePlayer) {
		val party = Party.getPlayerParty(player)
		if (party == null) {
			player.sendMessage(Utils.tacc("&7You are currently not in a party!"))
			return
		}
		if (party.getLeader() != player) {
			player.sendMessage(Utils.tacc("&cOnly the party leader can execute this command!"))
			return
		}
		if (playerToKick.player == party.getLeader()) {
			player.sendMessage(Utils.tacc("&cYou cannot kick the party leader!"))
		}
		party.kick(playerToKick.player)
	}

	@Subcommand("promote")
	@Syntax("<player>")
	@CommandCompletion("@partymembers")
	fun promoteToPartyLeader(player : Player, newLeader : OnlinePlayer) {
		val party = Party.getPlayerParty(player)
		if (party == null) {
			player.sendMessage(Utils.tacc("&7You are currently not in a party!"))
			return
		}
		if (party.getLeader() != player) {
			player.sendMessage(Utils.tacc("&cOnly the party leader can execute this command!"))
			return
		}
		if (!party.getMembers().contains(newLeader.player)) {
			player.sendMessage(Utils.tacc("&cThat player isn't a member of your party!"))
			return
		}
		party.setLeader(newLeader.player)
		party.send(
				MiniMessage.get()
						.parse(
								"<gold><oldLeaderDisplayName> <reset><gray>transferred the party to <gold><newLeaderDisplayName><reset><gray>!",
								listOf(
										Template.of(
												"oldLeaderDisplayName",
												player.displayName()
										           ),
										Template.of(
												"newLeaderDisplayName",
												newLeader.player.displayName()
										           )
								      )
						      )
		          )
	}

	@Subcommand("chat|c|send|message|m|msg")
	@Syntax("<message>")
	fun sendPartyMessage(player : Player, message : String) {
		val party = Party.getPlayerParty(player)
		if (party == null) {
			player.sendMessage(Utils.tacc("&7You are currently not in a party!"))
			return
		}
		party.send(
				MiniMessage.get().parse(
						"<light_purple>[PARTY] <gray><playerDisplayName><reset><gold> » <gray><message>",
						listOf(
								Template.of(
										"playerDisplayName",
										player.displayName()
								           ),
								Template.of(
										"message",
										LegacyComponentSerializer.legacyAmpersand()
												.deserialize(message)
								           )
						      )
				                       )
		          )
	}

	@Subcommand("info|i")
	@Syntax("[player]")
	@CommandCompletion("@players")
	fun partyInfo(player : Player, @Optional inviter : OnlinePlayer?) {
		val party = Party.getPlayerParty(inviter?.player ?: player)
		if (party == null) {
			player.sendMessage(Utils.tacc("&cYou are not in a party!"))
			return
		}
		player.sendMessage(
				Utils.tacc(
						listOf(
								"&6---- &7Party Info &6----",
								"&6Leader: &7${party.getLeader().name}",
								"&6Members: &7${
									party.getMembers()
											.map { m -> "&7${m.name}" }
											.joinToString("&6, ")
								}",
								"&6----------"
						      ).toTypedArray()
				          )
		                  )
	}

	@Subcommand("invite|inv")
	@Syntax("<player>")
	@CommandCompletion("@players")
	fun invitePlayerToParty(player : Player, invitee : OnlinePlayer) {
		val party = Party.getPlayerParty(player)
		if (party == null) {
			player.sendMessage(Utils.tacc("&7You are currently not in a party!"))
			return
		}
		if (party.getLeader() != player) {
			player.sendMessage(Utils.tacc("&cOnly the party leader can execute this command!"))
			return
		}
		if (party.getMembers().contains(invitee.player)) {
			player.sendMessage(Utils.tacc("&cThat player is already a member of your party!"))
			return
		}
		party.addInvite(invitee.player)

		// Kyori component used to let them run a command by clicking on the message
		val textComponent = MiniMessage.get().parse(
				"<hover:show_text:\"<gold>Click here to accept <pre>${player.name}</pre><gold>'s invite!\"><click:run_command:/party accept ${player.name}><gray>You have been invited to <gold><pre><playerDisplayName></pre><reset><gray>'s party! Type <gold>/party accept ${player.name} <gray>to join!",
				listOf(
						Template.of("playerDisplayName", player.displayName())
				      )
		                                           )
		invitee.player.sendMessage(textComponent)
		player.sendMessage(
				MiniMessage.get()
						.parse(
								"<gray>Successfully invited <gold><pre><inviteeName></pre>",
								listOf(
										Template.of(
												"inviteeName",
												invitee.player.displayName()
										           )
								      )
						      )
		                  )
	}

	@HelpCommand
	fun helpWithParty(player : Player) {
		player.sendMessage(
				Utils.tacc(
						listOf(
								"&6 ----- Party Commands -----",
								"&6/party create: &7Creates a party",
								"&6/party join [inviter]: &7Joins a party you've been invited to!",
								"&6/party leave|disband: &7Leaves/disbands the party you're in!",
								"&6/party kick <player>: &7Kicks a player from the party!",
								"&6/party promote <player>: &7Makes a member the new leader!",
								"&6/party send <message>: &7Sends a message to all the party members!",
								"&6/party invite <player>: &7Invites a player to the party!"
						      ).toTypedArray()
				          )
		                  )
	}

}
