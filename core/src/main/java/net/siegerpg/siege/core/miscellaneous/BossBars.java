package net.siegerpg.siege.core.miscellaneous;

import net.siegerpg.siege.core.listeners.tasks.GoldReward;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;

public class BossBars implements Listener {

	public static BossBar bar = Bukkit.createBossBar(
			Utils.tacc("&7Reward &e+"+GoldReward.serverGoldReward),
			BarColor.YELLOW,
			BarStyle.SOLID);

	@EventHandler
	public static void removePlayer(PlayerQuitEvent e) {
		bar.removePlayer(e.getPlayer());
	}

	@EventHandler
	public static void removePlayer(PluginDisableEvent e) {
		if (Bukkit.getOnlinePlayers().isEmpty()) return;
		for (Player player : Bukkit.getOnlinePlayers()) {
			bar.removePlayer(player);
		}
	}


	public static void showGoldProgress() {

		double goldDivision = Utils.round(((double) GoldReward.serverGold / GoldReward.goldRequirement) * 100, 1);

		bar.setProgress(goldDivision/100);
		bar.setVisible(true);
		if (!Bukkit.getOnlinePlayers().isEmpty()) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (!bar.getPlayers().contains(player)) bar.addPlayer(player);
			}
		}


		if (goldDivision > 80) {
			bar.setColor(BarColor.GREEN);
			bar.setTitle(Utils.tacc("&e&lGold Party &r&e+" + String.format("%,d", GoldReward.serverGoldReward) + " Gold &a" + goldDivision + "%"));
		} else if (goldDivision > 40) {
			bar.setColor(BarColor.YELLOW);
			bar.setTitle(Utils.tacc("&e&lGold Party &r&e+" + String.format("%,d", GoldReward.serverGoldReward) + " Gold &e" + goldDivision + "%"));
		} else {
			bar.setColor(BarColor.RED);
			bar.setTitle(Utils.tacc("&e&lGold Party &r&e+" + String.format("%,d", GoldReward.serverGoldReward) + " Gold &c" + goldDivision + "%"));
		}
	}
}
