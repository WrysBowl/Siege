package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.database.DatabaseManager;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.informants.Tablist;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.statgems.StrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shank;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Twig;
import net.siegerpg.siege.core.utils.Bank;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void connectEvent(AsyncPlayerPreLoginEvent e) {
        new BukkitRunnable() { // We create a runnable to run asynchronously (on another thread, not the main one, so that the server won't lag if this one does)
            @Override
            public void run() {
                String ip = e.getAddress().getHostAddress();
                // Add user ips to the db (So that we can in the future find all alts of an user)
                try (Connection conn = DatabaseManager.INSTANCE.getConnection()) {
                    PreparedStatement stat = conn.prepareStatement("SELECT ip FROM ipData WHERE uuid=? AND ip=?");
                    stat.setString(1, e.getUniqueId().toString());
                    stat.setString(2, ip);
                    ResultSet set = stat.executeQuery();
                    if (!set.isBeforeFirst()) {
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
            }
        }.runTaskAsynchronously(Core.plugin());
    }


    @EventHandler
    public void joinEvent(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        String joinMessage = Utils.tacc("&7[&a+&7] " + player.getName());

        if (Levels.INSTANCE.getExpLevel(player).getFirst() < 1) {
            player.getInventory().clear();
            player.getInventory().addItem(new Twig(Utils.randRarity()).getUpdatedItem(false));
            ItemStack food = new Drumstick(0).getUpdatedItem(false);
            food.setAmount(10);
            player.getInventory().addItem(food);
            VaultHook.econ.withdrawPlayer(player, VaultHook.econ.getBalance(player));
            VaultHook.econ.depositPlayer(player, 200.0);
            joinMessage = Utils.tacc("&a&lWELCOME&r &7[&a+&7] " + player.getName());
        }
        event.setJoinMessage(joinMessage);

        Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), new Runnable() {
            @Override
            public void run() {
                if (Levels.INSTANCE.getExpLevel(player).getFirst() < 1) {
                    Levels.INSTANCE.setLevel(player, (short) 1);
                }
            }
        });

        for (Player p : Bukkit.getOnlinePlayers()) {
            Scoreboard.updateScoreboard(p);
            Tablist.tablistUpdate(p);
        }

        for (int i = 0; i< player.getInventory().getSize(); i++) {
            CustomItem Cusitem = CustomItemUtils.INSTANCE.getCustomItem(player.getInventory().getItem(i));
            if (Cusitem != null) {
                player.getInventory().setItem(i, Cusitem.getUpdatedItem(false));
            }
        }


        if (player.getName().equals("Sumowu")) {
            Shank shank = new Shank(100);
            //shank.setStatGem(new StatGem(StatTypes.STRENGTH, 10.0));
            shank.updateMeta(false);
            player.getInventory().addItem(shank.getItem());
            StrengthGem gem = new StrengthGem(100);
            gem.setStatAmount(10.0);
            gem.updateMeta(false);
            player.getInventory().addItem(gem.getItem());
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
