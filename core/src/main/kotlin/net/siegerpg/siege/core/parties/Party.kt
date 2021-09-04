package net.siegerpg.siege.core.parties

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.entity.Player
import java.util.*

class Party(private val partyID: UUID, private var leader: OfflinePlayer) {
    private val invited: ArrayList<Player> = ArrayList()
    private val members: HashSet<OfflinePlayer> = HashSet()

    init {
        save()
        parties[partyID] = this
    }

    fun getLeader(): OfflinePlayer {
        return leader
    }

    fun addMember(member: OfflinePlayer) {
        members.add(member)
        save()
    }

    fun removeMember(member: OfflinePlayer) {
        members.remove(member)
        save()
    }

    fun getMembers(): HashSet<OfflinePlayer> {
        val guys: HashSet<OfflinePlayer> = HashSet()
        guys.addAll(this.members)
        guys.add(getLeader())
        return guys
    }

    fun isMember(player: OfflinePlayer): Boolean {
        return members.contains(player) || getLeader() == player
    }

    fun addInvite(invited: Player) {
        this.invited.add(invited)
        Bukkit.getScheduler().runTaskLaterAsynchronously(
            Core.plugin(),
            Runnable {
                send(Utils.tacc("&7The party invite to &6${invited.displayName()} &r&7expired!"))
                val leader = if (getLeader().isOnline) getLeader() as Player else null
                val leaderName = leader?.displayName() ?: getLeader().name
                invited.sendMessage(Utils.tacc("&7Party invite from &6${leaderName} &r&7has expired!"))
            }, (2 * 60 * 20).toLong()
        )
    }

    fun removeInvite(invited: Player) {
        this.invited.remove(invited)
    }

    fun isInvited(invited: Player): Boolean {
        return this.invited.contains(invited)
    }

    fun setLeader(newLeader: Player) {
        leader = newLeader
        save()
    }

    fun disband() {
        send(Utils.tacc("&7The party has been disbanded!"))
        members.clear()
        invited.clear()
        Core.plugin().partyConfig.setParty(partyID, null)
    }

    fun leave(player: Player) {
        if (getLeader() == player) disband()
        else if (isMember(player)) {
            send(Utils.tacc("&6${player.displayName()} &r&7has left the party!"))
            removeMember(player)
        }
    }

    fun send(message: String) {
        for (member in members) {
            if (member.isOnline) {
                val onlineMember = member as Player
                onlineMember.sendMessage(message)
            }
        }
    }


    companion object {
        val parties: HashMap<UUID, Party> = HashMap()

        fun deserialize(uuid: UUID, section: ConfigurationSection): Party {
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
    }

    private fun save() {
        val partySection = Core.plugin().partyConfig.getParty(partyID)
        partySection.set("members", members.map { m -> m.uniqueId.toString() })
        partySection.set("leader", getLeader().uniqueId.toString())
        Core.plugin().partyConfig.save()
    }
}