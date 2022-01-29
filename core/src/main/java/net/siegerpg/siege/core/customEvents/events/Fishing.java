package net.siegerpg.siege.core.customEvents.events;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.customEvents.CustomEvent;
import net.siegerpg.siege.core.customEvents.CustomEventListener;
import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.listeners.GoldExpListener;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;



public class Fishing extends CustomEvent {

	public static HashMap< Player, Integer> playerScores = new HashMap<>();
	public static HashMap< Player, ArrayList<Fish> > playerFishingHistory = new HashMap<>();

	public Fishing() {
		this.duration = 900;
	}

	public Fishing(int duration) {
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
		Bukkit.broadcast(Utils.parse("<color:#5AEBA2><bold>Fishing Tournament"));
		Bukkit.broadcast(Utils.parse("<gray>Duration (<aqua>"+Utils.secondsToHHMMSS(this.duration)+"<gray>)"));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("  <color:#5AEBA2>The harder the fish you catch,"));
		Bukkit.broadcast(Utils.parse("  <color:#5AEBA2>the higher your score becomes!"));
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
				if (!(CustomEventListener.currentlyActive instanceof Fishing)) this.cancel();
				sendLeaderboardTopLimit(10);
			}

		}.runTaskTimer(Core.plugin(), 300 * 20L, 300 * 20L);

			/*
		Send fishing history every 5 minutes
		 */
		new BukkitRunnable() {

			@Override
			public void run() {
				if (!(CustomEventListener.currentlyActive instanceof Fishing)) this.cancel();
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (!playerFishingHistory.containsKey(player)) continue;
					sendFishingHistory(player);
				}
			}

		}.runTaskTimer(Core.plugin(), 150 * 20L, 300 * 20L);
	}

	@Override
	public void clearAction() {

		List< Map.Entry<Player, Integer> > top3 = playerScores.entrySet().stream().sorted(
				Map.Entry.comparingByValue(reverseOrder())).limit(3).collect(toList());
		int counter = 1;
		int totalPoints = 0;
		Player winner = top3.get(0).getKey();
		if (winner==null) {
			Bukkit.broadcast(Utils.parse("<red>No one participated in the fishing tournament."));
			return;
		}

		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#5AEBA2><bold>Fishing Tournament END"));
		Bukkit.broadcast(Utils.parse("  <gold><bold>"+winner.getName()+" Winner"));
		Bukkit.broadcast(Utils.parse(""));

		for (Map.Entry<Player, Integer> entry : top3) {
			Bukkit.broadcast(Utils.parse("  <aqua>"+counter+" <yellow>"+entry.getKey().getName()+" <gray>scored <color:#E1CE55>"+entry.getValue()+" pts."));
			counter++;
			totalPoints += entry.getValue();
		}
		Bukkit.broadcast(Utils.parse(""));

		GoldExpListener.giveGold(winner, totalPoints);
		playerScores = null;
		playerFishingHistory = null;
	}

	public static void sendLeaderboardTopLimit(int limit) {
		List< Map.Entry<Player, Integer> > topPlayersLimit = playerScores.entrySet().stream().sorted(
				Map.Entry.comparingByValue(reverseOrder())).limit(limit).collect(toList());

		int counter = 1;

		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#5AEBA2><bold>Fishing Leaderboard"));
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

	public static int getFishScore(Fish fish) {
		return (int) ((100 * fish.winScore * fish.moveSpeed)/fish.length);
	}

	public static void sendFishingHistory(Player target) {
		int counter = 1;

		target.sendMessage(Utils.parse(""));
		target.sendMessage(Utils.parse("<color:#5AEBA2><bold>"+target.getName()+"'s Fishing History"));
		target.sendMessage(Utils.parse("<gold>Total Points: "+playerScores.get(target)));
		target.sendMessage(Utils.parse(""));
		for (Fish fish : playerFishingHistory.get(target)) {
			target.sendMessage(Utils.parse("  <yellow>"+counter+" <color:#E1CE55>"+fish.name+" " +
			                             "<gray>size <color:#F1E236>"+fish.actualSize+" <gray>gave <color:#F1E236>"+getFishScore(fish)+" <gray>pts."));
			counter++;
		}
		target.sendMessage(Utils.parse(""));

	}

}
