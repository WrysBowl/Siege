package net.siegerpg.siege.core.parties

import co.aikar.commands.BaseCommand
import co.aikar.commands.CommandCompletions
import co.aikar.commands.annotation.*
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.Template
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

	@Subcommand("create|c")
	@CommandAlias("new")
	fun createParty(player: Player) {
		val party = Party.getPlayerParty(player)
		if (party != null) {
			player.sendMessage(Utils.tacc("&7You are already in a party!"))
			return
		}
		player.sendMessage(Utils.tacc("&7Successfully created a party!"))
	}

	@Subcommand("join|j")
	@CommandAlias("accept")
	@Syntax("[inviter]")
	@CommandCompletion("@players")
	fun joinParty(player: Player, @Optional inviter: Player?) {
		val playerInvites = Party.getPlayerInvites(player)
		if (playerInvites.size == 0) {
			player.sendMessage(Utils.tacc("&7You haven't been invited to any parties!"))
			return
		} else if (playerInvites.size >= 1) {
			if (inviter != null) {
				val inviterParty = Party.getPlayerParty(inviter)
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
				partyInCommon.addMember(player)
			} else {
				val party = playerInvites[playerInvites.keys.first()]!!
				party.removeInvite(player)
				party.addMember(player)
			}
		}
	}

	@Subcommand("leave")
	@CommandAlias("disband")
	fun leaveParty(player: Player) {
		val party = Party.getPlayerParty(player)
		if (party == null) {
			player.sendMessage(Utils.tacc("&cYou are not currently in a party!"))
			return
		}
		party.leave(player)
	}

	@Subcommand("kick")
	@CommandAlias("remove")
	@Syntax("<player>")
	@CommandCompletion("partymembers")
	fun kickFromParty(player: Player, playerToKick: Player) {
		val party = Party.getPlayerParty(player)
		if (party == null) {
			player.sendMessage(Utils.tacc("&7You are currently not in a party!"))
			return
		}
		if (party.getLeader() != player) {
			player.sendMessage(Utils.tacc("&cOnly the party leader can execute this command!"))
			return
		}
		party.kick(playerToKick)
	}

	@Subcommand("promote")
	@Syntax("<player>")
	@CommandCompletion("partymembers")
	fun promoteToPartyLeader(player: Player, newLeader: Player) {
		val party = Party.getPlayerParty(player)
		if (party == null) {
			player.sendMessage(Utils.tacc("&7You are currently not in a party!"))
			return
		}
		if (party.getLeader() != player) {
			player.sendMessage(Utils.tacc("&cOnly the party leader can execute this command!"))
			return
		}
		if (!party.getMembers().contains(newLeader)) {
			player.sendMessage(Utils.tacc("&cThat player isn't a member of your party!"))
			return
		}
		party.setLeader(newLeader)
		party.send(Utils.tacc("&6${player.displayName()} &r&7transferred the party to &6${newLeader.displayName()}&r&7!"))
	}

	@Subcommand("chat|c|send|message|m|msg")
	@Syntax("<message>")
	fun sendPartyMessage(player: Player, message: String) {
		val party = Party.getPlayerParty(player)
		if (party == null) {
			player.sendMessage(Utils.tacc("&7You are currently not in a party!"))
			return
		}
		party.send(Utils.tacc("&6[PARTY] &r&6${player.displayName()} &r&6> &r&7$message"))
	}

	@Subcommand("invite|inv")
	@Syntax("<player>")
	@CommandCompletion("@players")
	fun invitePlayerToParty(player: Player, invitee: Player) {
		val party = Party.getPlayerParty(player)
		if (party == null) {
			player.sendMessage(Utils.tacc("&7You are currently not in a party!"))
			return
		}
		if (party.getLeader() != player) {
			player.sendMessage(Utils.tacc("&cOnly the party leader can execute this command!"))
			return
		}
		if (party.getMembers().contains(invitee)) {
			player.sendMessage(Utils.tacc("&cThat player is already a member of your party!"))
			return
		}
		party.addInvite(invitee)

		// Kyori component used to let them run a command by clicking on the message
		val textComponent = MiniMessage.get().parse(
			"<hover:show_text:\"<gold>Click here to accept <pre><playerDisplayName></pre><gold>'s invite!\"><click:run_command:/party accept <playerName>><gold>You have been invited to <pre><playerDisplayName></pre><reset><gray>'s party! Type <gold>/party accept <playerName> <gray>to join!",
			listOf(
				Template.of("playerDisplayName", player.displayName()),
				Template.of("playerName", player.name)
			)
		)
		invitee.sendMessage(textComponent)
	}

	@HelpCommand
	fun helpWithParty(player: Player) {
		player.sendMessage(
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
	}

}
