package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.database.DatabaseManager;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.GrieferChestplate;
import net.siegerpg.siege.core.items.implemented.weapons.melee.TestSword;
import net.siegerpg.siege.core.items.statgems.StatGem;
import net.siegerpg.siege.core.items.types.misc.StatGemType;
import net.siegerpg.siege.core.skills.Skills;
import net.siegerpg.siege.core.utils.Scoreboard;
import net.siegerpg.siege.core.utils.Tablist;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.wands.BeginnerLivingTwig;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.BeginnerClub;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.BeginnerTwig;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shank;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.BeginnerScrapyardBow;
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
                String uuid = e.getUniqueId().toString();
                // Add user ips to the db (So that we can in the future find all alts of an user)
                try (Connection conn = DatabaseManager.INSTANCE.getConnection()) {
                    PreparedStatement stat = conn.prepareStatement("SELECT ip FROM ipData WHERE uuid=? AND ip=?");
                    stat.setString(1, uuid);
                    stat.setString(2, ip);
                    ResultSet set = stat.executeQuery();
                    if (!set.isBeforeFirst()) {
                        PreparedStatement statement = conn.prepareStatement("INSERT INTO ipData (uuid, ip) VALUES (?, ?)");
                        statement.setString(1, uuid);
                        statement.setString(2, ip);
                        statement.executeUpdate();
                    }
                } catch (SQLException ignored) {
                }
            }
        }.runTaskAsynchronously(Core.plugin());
    }


    @EventHandler
    public void joinEvent(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        String prefix = net.siegerpg.siege.core.utils.VaultHook.perms.getPrimaryGroup(player);
        String joinMessage = Utils.tacc("&a&lJOIN &7[&a+&7] " + prefix + " &7" + player.getName());
        player.teleport(Core.plugin().getServer().getWorld("Hub").getSpawnLocation());

        if (Levels.INSTANCE.getExpLevel(player).getFirst() < 1) {
            try (Connection conn = DatabaseManager.INSTANCE.getConnection()) {
                // Add the user to the db if he doesn't exist
                PreparedStatement userData = conn.prepareStatement("INSERT INTO userData (uuid) VALUES (?)");
                userData.setString(1, player.getUniqueId().toString());
                userData.executeUpdate();
            }catch (SQLException ignored) { }
        }
        if (event.getPlayer().getName().equals("Wrys")) {

        }


        if (!player.hasPlayedBefore()) {
            player.getInventory().clear();
            player.getInventory().addItem(new BeginnerTwig(50).getUpdatedItem(false));
            player.getInventory().addItem(new BeginnerClub(50).getUpdatedItem(false));
            player.getInventory().addItem(new BeginnerScrapyardBow(50).getUpdatedItem(false));
            player.getInventory().addItem(new BeginnerLivingTwig(50).getUpdatedItem(false));
            ItemStack food = new Drumstick(0).getUpdatedItem(false);
            food.setAmount(10);
            player.getInventory().addItem(food);
            VaultHook.econ.withdrawPlayer(player, VaultHook.econ.getBalance(player));
            VaultHook.econ.depositPlayer(player, 400.0);
            joinMessage = Utils.tacc("&a&lWELCOME&r &7[&a+&7] " + prefix + " &7" + player.getName());
        }
        event.setJoinMessage(joinMessage);

        for (Player p : Bukkit.getOnlinePlayers()) {
            Scoreboard.updateScoreboard(p);
            Tablist.tablistUpdate(p);
        }

        /*if (event.getPlayer().getName().equals("Wrys")) {
            player.getInventory().addItem(new TestSword(150).getUpdatedItem(false));
            if (Skills.INSTANCE.getSkills(player).equals("")) {
                try (Connection conn = DatabaseManager.INSTANCE.getConnection()) {
                    PreparedStatement skillsData = conn.prepareStatement("INSERT INTO skillsData (uuid) VALUES (?)");
                    skillsData.setString(1, player.getUniqueId().toString());
                    skillsData.executeUpdate();
                } catch (SQLException ignored) {
                }
            }
            Skills.INSTANCE.setSkills(player, "A_1_3");
        }*/

        for (int i = 0; i< player.getInventory().getSize(); i++) {
            CustomItem CusItem = CustomItemUtils.INSTANCE.getCustomItem(player.getInventory().getItem(i));
            if (CusItem == null) continue;
            if (CusItem instanceof StatGemType) continue;

            player.getInventory().setItem(i, CusItem.getUpdatedItem(false));
        }
    }
}
