package net.siegerpg.siege.core.customEvents.events;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.customEvents.CustomEvent;
import net.siegerpg.siege.core.customEvents.CustomEventListener;
import net.siegerpg.siege.core.listeners.GoldExpListener;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;


public class Mobs extends CustomEvent {

	public static HashMap< Player, Integer> playerScores = new HashMap<>();

	public Mobs() {
		this.duration = 900;
	}

	public Mobs(int duration) {
		this.duration = duration;
	}

	@Override
	public boolean triggerable() {
		return Utils.randTest(30.0);
	}

	@Override
	public void action() {

		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#ed5f5f><bold>Mob Tournament"));
		Bukkit.broadcast(Utils.parse("<gray>Duration (<aqua>"+Utils.secondsToHHMMSS(this.duration)+"<gray>)"));
		Bukkit.broadcast(Utils.parse("<color:#e6a05e>3 Players Required"));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("  <color:#ed5f5f>The harder the mobs you kill"));
		Bukkit.broadcast(Utils.parse("  <color:#ed5f5f>the more points you will get."));
		Bukkit.broadcast(Utils.parse("  <color:#d43333><bold>WARNING <r><color:#ed5f5f>Boss kills are not tracked!"));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#E1CE55>Winner collects all the points in gold."));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));

		/*
		Send leaderboard every 5 minutes
		 */
		new BukkitRunnable() {

			@Override
			public void run() {
				if (!(CustomEventListener.currentlyActive instanceof Mobs)) this.cancel();
				if (playerScores == null) this.cancel();
				if (playerScores.isEmpty()) this.cancel();
				sendLeaderboardTopLimit(10);
			}

		}.runTaskTimer(Core.plugin(), 300 * 20L, 300 * 20L);
	}

	@Override
	public void clearAction() {

		List< Map.Entry<Player, Integer> > top3 = playerScores.entrySet().stream().sorted(
				Map.Entry.comparingByValue(reverseOrder())).limit(3).collect(toList());
		playerScores.clear();
		if (top3.size() < 3) {
			Bukkit.broadcast(Utils.parse("<red>Not enough people participated in this tournament."));
			return;
		}

		int counter = 1;
		int totalPoints = 0;
		Player winner = top3.get(0).getKey();

		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#ed5f5f><bold>Mob Tournament END"));
		Bukkit.broadcast(Utils.parse("  <gold><bold>"+winner.getName()+" Winner"));
		Bukkit.broadcast(Utils.parse(""));

		for (Map.Entry<Player, Integer> entry : top3) {
			Bukkit.broadcast(Utils.parse("  <aqua>"+counter+" <yellow>"+entry.getKey().getName()+" <gray>scored <color:#E1CE55>"+entry.getValue()+" pts."));
			counter++;
			totalPoints += entry.getValue();
		}
		Bukkit.broadcast(Utils.parse(""));

		GoldExpListener.giveGold(winner, totalPoints);
	}

	public static void sendLeaderboardTopLimit(int limit) {
		List< Map.Entry<Player, Integer> > topPlayersLimit = playerScores.entrySet().stream().sorted(
				Map.Entry.comparingByValue(reverseOrder())).limit(limit).collect(toList());

		int counter = 1;

		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#ed5f5f><bold>Mob Leaderboard"));
		Bukkit.broadcast(Utils.parse("  <gold>Prize Pool <color:#E1CE55>"+getTotalPoints()+" \u26C1"));
		Bukkit.broadcast(Utils.parse(""));
		for (Map.Entry<Player, Integer> entry : topPlayersLimit) {
			Bukkit.broadcast(Utils.parse("  <aqua>"+counter+" <color:#7ADDAB>"+entry.getKey().getName()+" <gray>scored <color:#E1CE55>"+entry.getValue()+" pts."));
			counter++;
		}
		Bukkit.broadcast(Utils.parse(""));

	}

	private static int getTotalPoints() {
		int totalPoints = 0;
		for (Integer value : playerScores.values()) {
			totalPoints+=value;
		}
		return totalPoints;
	}


}
