package net.siegerpg.siege.core.parties

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.Template
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.entity.Player
import java.time.Instant
import java.util.*

class Party(public val partyID : UUID, private var leader : OfflinePlayer) {

	private val invited : ArrayList<Player> = ArrayList()
	private val members : HashSet<OfflinePlayer> = HashSet()

	private var lastJoin : Instant = Instant.now()

	constructor(leader : OfflinePlayer) : this(UUID.randomUUID(), leader)

	init {
		parties[partyID] = this
	}

	fun getLeader() : OfflinePlayer {
		return leader
	}

	fun addMember(member : OfflinePlayer) {
		members.add(member)
		lastJoin = Instant.now()
		save()
	}

	fun removeMember(member : OfflinePlayer) {
		members.remove(member)
		save()
		Bukkit.getScheduler().runTaskLater(Core.plugin(), Runnable {
			if (getMembers().size < 2 && lastJoin.plusSeconds(60L * 5)
							.isBefore(Instant.now())
			) {
				send(Utils.tacc("&cThe party was disbanded because nobody was in it for 5 minutes!"))
				disband()
			}
		}, 20L * 60 * 5)
	}

	fun getMembers() : HashSet<OfflinePlayer> {
		val guys : HashSet<OfflinePlayer> = HashSet()
		guys.addAll(this.members)
		guys.add(getLeader())
		return guys
	}

	fun isMember(player : OfflinePlayer) : Boolean {
		return getMembers().contains(player)
	}

	fun addInvite(invited : Player) {
		this.invited.add(invited)
		Bukkit.getScheduler().runTaskLaterAsynchronously(
				Core.plugin(),
				Runnable {
					if (!this.invited.contains(invited)) return@Runnable
					send(
							MiniMessage.get()
									.parse(
											Utils.tacc("&7The party invite to &6<invitedDisplayName> &r&7expired!"),
											listOf(
													Template.of(
															"invitedDisplayName",
															invited.displayName()
													           )
											      )
									      ),

							)
					val leader = if (getLeader().isOnline) getLeader() as Player else null
					val leaderName = leader?.displayName() ?: getLeader().name
					invited.sendMessage(Utils.tacc("&7Party invite from &6${leaderName} &r&7has expired!"))
				}, (2 * 60 * 20).toLong()
		                                                )
	}

	fun removeInvite(invited : Player) {
		this.invited.remove(invited)
	}

	fun isInvited(invited : Player) : Boolean {
		return this.invited.contains(invited)
	}

	fun setLeader(newLeader : Player) {
		if (!isMember(newLeader)) return
		addMember(leader)
		removeMember(newLeader)
		leader = newLeader
		save()
	}

	fun disband() {
		send(Utils.tacc("&7The party has been disbanded!"))
		delete()
	}

	fun delete() {
		members.clear()
		invited.clear()
		parties.remove(partyID)
		Core.plugin().partyConfig.setParty(partyID, null)
	}

	fun leave(player : Player) {
		if (getLeader() == player) disband()
		else if (isMember(player)) {
			send(
					MiniMessage.get().parse(
							"<gold><displayName> <reset><gray>has left the party!",
							listOf(
									Template.of("displayName", player.displayName())
							      )
					                       )
			    )
			removeMember(player)
		}
	}

	fun send(message : Component) {
		for (member in getMembers()) {
			if (member.isOnline) {
				val onlineMember = member as Player
				onlineMember.sendMessage(message)
			}
		}
	}

	fun send(message : String) {
		for (member in getMembers()) {
			if (member.isOnline) {
				val onlineMember = member as Player
				onlineMember.sendMessage(message)
			}
		}
	}

	fun kick(player : Player) {
		if (player == getLeader()) {
			send(Utils.tacc("&6${leader.name} &r&7can't be kicked from the party!"))
			return
		}
		send(
				MiniMessage.get()
						.parse(
								"<gold>${leader.name} <gray>kicked <gold><kickedDisplayName> <reset><gray>from the party!",
								listOf(
										Template.of(
												"kickedDisplayName",
												player.displayName()
										           )
								      )
						      ),
		    )
		removeMember(player)
	}


	companion object {

		val parties : HashMap<UUID, Party> = HashMap()

		fun deserialize(uuid : UUID, section : ConfigurationSection) : Party {
			val leaderID = UUID.fromString(section.getString("leader"))
			val leader = Bukkit.getOfflinePlayer(leaderID)
			val party = Party(uuid, leader)
			section.getStringList("members").forEach { member ->
				val memberID = UUID.fromString(member)
				val memberOfflinePlayer = Bukkit.getOfflinePlayer(memberID)
				party.addMember(memberOfflinePlayer)
			}

			return party
		}

		fun getPlayerParty(player : OfflinePlayer) : Party? {
			for ((_, party) in parties) {
				if (party.isMember(player))
					return party
			}
			return null
		}

		fun getPlayerInvites(player : Player) : HashMap<UUID, Party> {
			val partiesWithInvites = hashMapOf<UUID, Party>()
			for ((partyID, party) in parties) {
				if (party.isInvited(player)) {
					partiesWithInvites[partyID] = party
				}
			}
			return partiesWithInvites
		}
	}

	private fun save() {
		val partySection = Core.plugin().partyConfig.getParty(partyID)
		partySection.set(
				"members",
				members.map { m -> m.uniqueId.toString() }.toTypedArray()
		                )
		partySection.set("leader", getLeader().uniqueId.toString())
		Core.plugin().partyConfig.save()
	}
}