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


public class BlockBreak extends CustomEvent {

	public static HashMap< Player, Integer> playerScores = new HashMap<>();

	public BlockBreak() {
		this.duration = 900;
	}

	public BlockBreak(int duration) {
		this.duration = duration;
	}

	@Override
	public boolean triggerable() {
		return Utils.randTest(20.0);
	}

	@Override
	public void action() {

		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#5ebbe6><bold>Block Breaking Tournament"));
		Bukkit.broadcast(Utils.parse("<gray>Duration (<aqua>"+Utils.secondsToHHMMSS(this.duration)+"<gray>)"));
		Bukkit.broadcast(Utils.parse("<color:#e6a05e>3 Players Required"));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("  <color:#5ebbe6>The more blocks you break"));
		Bukkit.broadcast(Utils.parse("  <color:#5ebbe6>the more points you get."));
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
				if (!(CustomEventListener.currentlyActive instanceof BlockBreak)) this.cancel();
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
		Player winner = top3.get(0).getKey();

		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#5ebbe6><bold>Block Breaking Tournament END"));
		Bukkit.broadcast(Utils.parse("  <gold><bold>"+winner.getName()+" Winner"));
		Bukkit.broadcast(Utils.parse(""));

		for (Map.Entry<Player, Integer> entry : top3) {
			Bukkit.broadcast(Utils.parse("  <aqua>"+counter+" <yellow>"+entry.getKey().getName()+" <gray>scored <color:#E1CE55>"+entry.getValue()+" pts."));
			counter++;
		}
		Bukkit.broadcast(Utils.parse(""));

		GoldExpListener.giveGold(winner, getTotalPoints());
	}

	public static void sendLeaderboardTopLimit(int limit) {
		List< Map.Entry<Player, Integer> > topPlayersLimit = playerScores.entrySet().stream().sorted(
				Map.Entry.comparingByValue(reverseOrder())).limit(limit).collect(toList());

		int counter = 1;

		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#5ebbe6><bold>Block Breaking Leaderboard"));
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
