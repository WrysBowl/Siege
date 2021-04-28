package net.siegerpg.siege.core.party;

import lombok.Getter;
import net.siegerpg.siege.core.Core;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("ALL")
public class Party {
    @Getter private final UUID partyID = UUID.randomUUID();
    @Getter private final List<UUID> invited = new ArrayList<>();
    private HashSet<UUID> members = new HashSet<>();
    private UUID leader = null;

    /**
     * Create a new party
     *
     * @param leader The leader of the party
     */
    public Party(Player leader) {
        this.setLeader(leader.getUniqueId());
        save();
    }

    /**
     * Create a new party
     *
     * @param partyID The uuid of the party, used to retrieve the party from the config.
     */
    public Party(UUID partyID) {
        //  FileConfiguration config = Core.plugin().partyConfig.getConfiguration(); TODO: Uncomment when adding parties back
//        String leader = config.getString("party." + partyID.toString() + ".leader");
//        List<String> members = config.getStringList("party." + partyID.toString() + ".members");
//        if (leader == null) {
//            Core.INSTANCE.getLogger().warning("Failed to fetch data for party ID " + partyID.toString());
//            return;
//        }

//        UUID partyLeader = UUID.fromString(leader);
//        List<UUID> membersConverted = new ArrayList<>();
//        members.forEach((String u) -> membersConverted.add(UUID.fromString(u)));
//
//        this.partyID = partyID;
//        this.setLeader(partyLeader);
//        for (UUID uuid : membersConverted) addMember(uuid);
    }

    /**
     * Get the leader of the party
     *
     * @return OfflinePlayer, the leader
     */
    public OfflinePlayer getLeader() {
        return Bukkit.getOfflinePlayer(leader);
    }

    /**
     * Add a member to the party
     *
     * @param memberUUID The uuid of the player
     */
    public void addMember(UUID memberUUID) {
        members.add(memberUUID);
        save();
    }

    /**
     * Remove a member from the party
     *
     * @param memberUUID The uuid of the player
     */
    public void removeMember(UUID memberUUID) {
        members.remove(memberUUID);
        save();
    }

    /**
     * Get the members of the party
     *
     * @return The members AND the leader
     */
    public ArrayList<OfflinePlayer> getMembers() {
        ArrayList<OfflinePlayer> list = new ArrayList<>();
        list.add(getLeader());
        for (UUID uuid : members) list.add(Bukkit.getOfflinePlayer(uuid));
        return list;
    }

    /**
     * Get the uuids of the members of the party
     *
     * @return The uuids of the members AND the leader
     */
    public List<UUID> getMembersRaw() {
        List<UUID> list = new ArrayList<>();
        list.add(leader);
        list.addAll(members);
        return list;
    }

    /**
     * See whether or not an UUID is apart of the members
     *
     * @param playerUUID
     * @return
     */
    public boolean isMember(UUID playerUUID) {
        return getMembersRaw().contains(playerUUID);
    }

    /**
     * Add a player to the list of pending invitees (and automatically remove them after 1200 ticks if they haven't joined)
     *
     * @param invitee
     */
    public void addInvite(Player invitee) {
        invited.add(invitee.getUniqueId());
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!isInvited(invitee)) return;
                removeInvite(invitee);
                send(invitee.getName() + " did not join the party!");
                invitee.sendMessage("§cParty invite from " + getLeader().getName() + " has expired!");
                if (members.size() == 0) {
                    send("The party was disbanded since there was only 1 person left!");
                    disband();
                }
            }
        }.runTaskLaterAsynchronously(Core.INSTANCE, 1200);
    }

    /**
     * Remove the invitee from the invitees
     *
     * @param invitee
     */
    public void removeInvite(Player invitee) {
        invited.remove(invitee.getUniqueId());
    }

    /**
     * Check whether a player is invited
     *
     * @param invitee
     * @return
     */
    public boolean isInvited(Player invitee) {
        return invited.contains(invitee.getUniqueId());
    }

    /**
     * Change the leader of the party
     *
     * @param leader
     */
    public void setLeader(UUID leader) {
        if (this.leader != null) {
            Core.partyManager.getParties().remove(this.leader);
            this.addMember(this.leader);
        }
        this.leader = leader;
        if (members.contains(leader)) this.removeMember(leader);
        Core.partyManager.getParties().put(leader, this);
        save();
    }

    /**
     * Disband the party
     */
    public void disband() {
        Core.partyManager.getParties().remove(leader);
        this.members.clear();
        this.invited.clear();
        // Core.plugin().partyConfig.getConfiguration().set("party." + partyID.toString(), null); TODO: Uncomment when parties
    }

    /**
     * Leave the party
     *
     * @param player
     */
    public void leave(Player player) {
        if (isMember(player.getUniqueId())) removeMember(player.getUniqueId());
        if (getLeader() == player) disband();
        send(player.getName() + " left the party!");
    }

    /**
     * Send a message to all party members
     *
     * @param message
     */
    public void send(String message) {
        for (OfflinePlayer player : getMembers()) {
            if (player.isOnline()) {
                ((Player) player).sendMessage("§b[PARTY] §7" + message);
            }
        }
    }

    /**
     * Save all members to the config
     *
     * @param save Whether to save the config or keep it in memory only
     */
    public void save(boolean save) {
        List<String> membersString = new ArrayList<>();
//        FileConfiguration config = Core.plugin().partyConfig.getConfiguration();
//        members.forEach((UUID u) -> membersString.add(u.toString()));
//        config.set("party." + partyID.toString() + ".id", getPartyID().toString());
//        config.set("party." + partyID.toString() + ".leader", leader.toString());
//        config.set("party." + partyID.toString() + ".members", membersString);
//        if (save)
//            try {Core.plugin().partyConfig.save(); } catch(Exception ignored){} TODO: Uncomment when parties
    }

    /**
     * Save all members to the config (in memory)
     */
    public void save() {
        save(false);
    }
}
