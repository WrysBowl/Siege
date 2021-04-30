package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.informants.Tablist;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shank;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinListener implements Listener {
    /*
    @EventHandler
    public void connectEvent(AsyncPlayerPreLoginEvent e) {
        new BukkitRunnable() { // We create a runnable to run asynchronously (on another thread, not the main one, so that the server won't lag if this one does)
            @Override
            public void run() {
                String ip = e.getAddress().getHostAddress();
                Connection conn = DbManager.getConnection(); // Get the connection from the pool
                // Add user ips to the db (So that we can in the future find all alts of an user)
                try {
                    PreparedStatement stat = conn.prepareStatement("SELECT * FROM ipData WHERE uuid=? AND ip=?");
                    stat.setString(1, e.getUniqueId().toString());
                    stat.setString(2, ip);
                    ResultSet set = stat.executeQuery();
                    if (set.getFetchSize() < 1) {
                        PreparedStatement statement = conn.prepareStatement("INSERT INTO ipData (uuid, ip) VALUES (?, ?)");
                        statement.setString(1, e.getUniqueId().toString());
                        statement.setString(2, ip);
                        statement.executeUpdate();
                    }
                    // Add the user to the db if he doesn't exist
                    PreparedStatement userData = conn.prepareStatement("INSERT INTO userData (uuid) VALUES (?)");
                    userData.setString(1, e.getUniqueId().toString());
                    userData.executeUpdate();
                } catch (SQLException ignored) {
                }
                DbManager.releaseConnection(conn); // Release the connection so it can be used by others
            }
        }.runTaskAsynchronously(Core.plugin());
    }
    */

    /*
    @EventHandler
    public void loginEvent(PlayerLoginEvent event) {
        Player p = event.getPlayer();
        if(!p.hasPlayedBefore()) {

        }
    }

     */

    @EventHandler
    public void joinEvent(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        event.setJoinMessage(Utils.tacc("&7[&a+&7] " + player.getName()));

        for (Player p : Bukkit.getOnlinePlayers()) {
            Scoreboard.updateScoreboard(p);
            Tablist.tablistUpdate(p);
        }

        if (Levels.getLevel(player) < 1) {
            Levels.setLevel(player, (short) 1);
        }
        if (!(player.hasPlayedBefore())) {
            player.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));
            player.getInventory().addItem(new ItemStack(Material.STONE_SHOVEL));
            player.getInventory().addItem(new ItemStack(Material.WOODEN_AXE));
        }

        if (player.getName().equals("Sumowu")) {
            player.getInventory().addItem(new Shank(150).getUpdatedItem(false));
        }

        /*
        for (DungeonType dungeonType : DungeonType.dungeonTypes) {
            for (Dungeon dungeon : dungeonType.dungeons) {
                if (dungeon.listPlayers().contains(player) && player.getLocation().distanceSquared(dungeon.location) > dungeonType.dungeonDistance * dungeonType.dungeonDistance) {
                    player.teleport(dungeon.location.clone().add(dungeonType.spawnLocation));
                    return;
                }
            }
        }
        */

        player.teleport(Core.plugin().getServer().getWorld("SiegeHub").getSpawnLocation());
    }
}