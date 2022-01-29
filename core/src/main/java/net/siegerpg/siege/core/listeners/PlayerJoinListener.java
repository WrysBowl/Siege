package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.database.DatabaseManager;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.CommonKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.tools.WoodenAxe;
import net.siegerpg.siege.core.items.implemented.misc.tools.WoodenPickaxe;
import net.siegerpg.siege.core.items.implemented.misc.tools.WoodenShovel;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Twig;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
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

		String prefix = net.siegerpg.siege.core.miscellaneous.VaultHook.perms.getPrimaryGroup(player);
		String joinMessage = Utils.tacc("&a&lJOIN &7[&a+&7] " + prefix + " &7" + player.getName());

		//Sets level into database
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
			player.teleport(Core.plugin().getNewSpawnLocation());
		} else {
			new BukkitRunnable() { // We create a runnable to run asynchronously (on another thread, not the main one, so that the server won't lag if this one does)
				@Override
				public void run() {
					updateInventory(player);
				}
			}.runTaskAsynchronously(Core.plugin());
		}
		event.setJoinMessage(joinMessage);

		for (Player p : Bukkit.getOnlinePlayers()) {
			Scoreboard.updateScoreboard(p);
			Tablist.tablistUpdate(p);
		}
		if (player.getName().equals("Wrys")) {

		}
		player.playSound(player.getLocation(), Sound.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, 1.0f, 1.0f);
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
		player.getInventory().addItem(new Twig(50).getUpdatedItem(false));
		player.getInventory().addItem(new WoodenPickaxe(0).getUpdatedItem(false));
		player.getInventory().addItem(new WoodenAxe(0).getUpdatedItem(false));
		player.getInventory().addItem(new WoodenShovel(0).getUpdatedItem(false));
		player.getInventory().addItem(new Drumstick().getUpdatedItem(false).asQuantity(10));
		player.getInventory().addItem(new MobKey(0).getUpdatedItem(false).asQuantity(3));
		player.getInventory().addItem(new CommonKey().getUpdatedItem(false).asQuantity(1));

		VaultHook.econ.withdrawPlayer(player, VaultHook.econ.getBalance(player));
		VaultHook.econ.depositPlayer(player, 400.0);
	}

}
