package net.siegerpg.siege.core.customEvents.events;

import net.siegerpg.siege.core.customEvents.CustomEvent;
import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

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
		Bukkit.broadcast(Utils.parse("<color:#5AEBA2>The harder the fish you catch,"));
		Bukkit.broadcast(Utils.parse("<color:#5AEBA2>the higher your score becomes!"));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));

	}

	@Override
	public void clearAction() {

		List< Map.Entry<Player, Integer> > top3 = playerScores.entrySet().stream().sorted(
				Map.Entry.comparingByValue(reverseOrder())).limit(3).collect(toList());
		int counter = 1;

		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#5AEBA2><bold>Fishing Tournament END"));
		Bukkit.broadcast(Utils.parse("<color:#5AEBA2>Top Players:"));
		for (Map.Entry<Player, Integer> entry : top3) {
			Bukkit.broadcast(Utils.parse("  <aqua>"+counter+" <color:#7ADDAB>"+entry.getKey().getName()+" <gray>scored <color:#E1CE55>"+entry.getValue()+" pts."));
			counter++;
		}
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		playerScores = null;
	}

	public void sendLeaderboardTopLimit(int limit) {
		List< Map.Entry<Player, Integer> > topPlayersLimit = playerScores.entrySet().stream().sorted(
				Map.Entry.comparingByValue(reverseOrder())).limit(limit).collect(toList());
		//TODO Write leaderboard for top players

	}

	public void sendFishingHistory(Player target) {
		int counter = 1;

		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<color:#5AEBA2><bold>Fishing Tournament END"));
		Bukkit.broadcast(Utils.parse("<color:#5AEBA2>Top Players:"));
		for (Fish fish : playerFishingHistory.get(target)) {
			Bukkit.broadcast(Utils.parse("  <yellow>"+counter+" <color:#E1CE55>"+fish.name+" " +
			                             "<gray>size <color:#F1E236>"+fish.actualSize+" gave "+playerScores.get(target)+" pts."));
			counter++;
		}
		Bukkit.broadcast(Utils.parse(""));
		Bukkit.broadcast(Utils.parse("<dark_gray><underlined>                                   "));
		Bukkit.broadcast(Utils.parse(""));

	}

}
