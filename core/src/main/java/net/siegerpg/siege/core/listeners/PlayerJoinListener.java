package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.database.DatabaseManager;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Twig;
import net.siegerpg.siege.core.listeners.tasks.GoldReward;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
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

				String ip = e
						.getAddress()
						.getHostAddress();
				String uuid = e
						.getUniqueId()
						.toString();
				// Add user ips to the db (So that we can in the future find all alts of an user)
				try (Connection conn = DatabaseManager.INSTANCE.getConnection()) {
					PreparedStatement stat = conn.prepareStatement(
							"SELECT ip FROM ipData WHERE uuid=? AND ip=?");
					stat.setString(1, uuid);
					stat.setString(2, ip);
					ResultSet set = stat.executeQuery();
					if (!set.isBeforeFirst()) {
						PreparedStatement statement = conn.prepareStatement(
								"INSERT INTO ipData (uuid, ip) VALUES (?, ?)");
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

		String prefix = net.siegerpg.siege.core.miscellaneous.VaultHook.perms.getPrimaryGroup(
				player);
		String joinMessage = Utils.tacc("&a&lJOIN &7[&a+&7] " + prefix + " &7" + player.getName());
		player.teleport(Core
				                .plugin()
				                .getHubSpawnLocation());

		Levels.INSTANCE.getExpLevel(player, shortIntegerPair -> {
			if (shortIntegerPair == null) {
				try (Connection conn = DatabaseManager.INSTANCE.getConnection()) {
					// Add the user to the db if he doesn't exist
					PreparedStatement userData = conn.prepareStatement(
							"INSERT INTO userData (uuid) VALUES (?)");
					userData.setString(1, player
							.getUniqueId()
							.toString());
					userData.executeUpdate();
				} catch (SQLException ignored) {
				}

			}
			return null;
		});

		if (!player.hasPlayedBefore()) {
			newPlayerReward(player);
			joinMessage = Utils.tacc(
					"&a&lWELCOME&r &7[&a+&7] " + prefix + " &7" + player.getName());
		} else {
			new BukkitRunnable() { // We create a runnable to run asynchronously (on another thread, not the main one, so that the server won't lag if this one does)
				@Override
				public void run() {

					updateInventory(player);
				}
			}.runTaskAsynchronously(Core.plugin());
		}
		event.setJoinMessage(joinMessage);
		player.setWalkSpeed(0.3f);

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
		player.getInventory().addItem(new MobKey(0).getUpdatedItem(false).asQuantity(4));

		player.teleport(new Location(Core.plugin().getServer().getWorld("Hub"), 0.5, 100, 0.5, 90, 0));
		player.playSound(player.getLocation(), Sound.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, 1.0f, 1.0f);
		GoldReward.addPlayer(event);
	}

	public void updateInventory(Player player) {
		for (int i = 0; i < player.getInventory().getSize(); i++) {
			CustomItem CusItem = CustomItemUtils.INSTANCE.getCustomItem(player.getInventory().getItem(i));
			if (CusItem == null) continue;
			player.getInventory().setItem(i, CusItem.getUpdatedItem(false));
		}
	}

	public void newPlayerReward(Player player) {

		player.getInventory().clear();
		player.getInventory().addItem(new Twig(50).getUpdatedItem(false).asQuantity(4));
		ItemStack food = new Drumstick(0).getUpdatedItem(false).asQuantity(10);
		player.getInventory().addItem(food);
		VaultHook.econ.withdrawPlayer(player, VaultHook.econ.getBalance(player));
		VaultHook.econ.depositPlayer(player, 400.0);
	}

}
