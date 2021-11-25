package net.siegerpg.siege.core.miscellaneous;

import kotlin.Pair;
import net.siegerpg.siege.core.miscellaneous.cache.GlobalMultipliers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

public class Scoreboard {

	public static void updateScoreboard(Player p) {

		if (p
				.getScoreboard()
				.equals(Bukkit
						        .getServer()
						        .getScoreboardManager()
						        .getMainScoreboard()))
			p.setScoreboard(Bukkit
					                .getServer()
					                .getScoreboardManager()
					                .getNewScoreboard()); //Per-player scoreboard, not necessary if all the same data, but we're personalizing the displayname and all
		org.bukkit.scoreboard.Scoreboard b = Bukkit
				.getScoreboardManager()
				.getNewScoreboard();
		Objective o = b.getObjective(p.getName()) == null
		              ? b.registerNewObjective(p.getName(), "Title",
		                                       Utils.lore("<gold>SiegeRPG <gray>(" + Bukkit
				                                       .getOnlinePlayers()
				                                       .size() + "/" + Bukkit.getMaxPlayers() + ")")
		                                      ) : b.getObjective(
				p.getName()); //Per-player objectives, even though it doesn't matter what it's called since we're using per-player scoreboards.
		assert o != null;

		Pair< Short, Integer > expLevel = Levels.INSTANCE.blockingGetExpLevel(p);
		if (expLevel == null) expLevel = new Pair<>((short) 1, 0);

		float reqExp = Levels.INSTANCE.calculateRequiredExperience(expLevel.getFirst());
		double division = expLevel.getSecond() / reqExp;
		double levelPercent = Utils.round(division, 3);
		String gold = String.format("%,d", (int) VaultHook.econ.getBalance(p));

		replaceScore(o, 15, " ");
		replaceScore(
				o, 14, Utils.tacc("&6&lWorld &r&7") + p
						.getWorld()
						.getName());
		replaceScore(
				o, 13, Utils.tacc(
						"&6Profile " + VaultHook.perms.getPrimaryGroup(p) + " &7" + p.getName()));
		replaceScore(
				o, 12, Utils.tacc("&7\u2560 Level &5" + expLevel.getFirst() + " &d(" +
				                  Utils.round(levelPercent * 100, 2) + "%)"));
		replaceScore(o, 11, Utils.tacc("&7\u2560 Gold &e" + gold));
		if (GlobalMultipliers.expMultiplier > 1.0 || GlobalMultipliers.goldMultiplier > 1.0) {
			replaceScore(o, 10, "  ");
			replaceScore(o, 9, Utils.tacc("&6Global"));
			if (GlobalMultipliers.expMultiplier > 1.0) {
				replaceScore(
						o, 8,
						Utils.tacc("&7\u2560 &7EXP &d" + (GlobalMultipliers.expMultiplier-1)*100 + "%"));
			}
			if (GlobalMultipliers.goldMultiplier > 1.0) {
				replaceScore(
						o, 7, Utils.tacc("&7\u2560 &7Gold &e" + (GlobalMultipliers.goldMultiplier-1)*100 + "%"));
			}
		}
		replaceScore(o, 6, "   ");
		replaceScore(o, 5, Utils.tacc("&7play.SiegeRPG.net"));
		if (o.getDisplaySlot() != DisplaySlot.SIDEBAR)
			o.setDisplaySlot(DisplaySlot.SIDEBAR); //Vital functionality
		p.setScoreboard(b); //Vital functionality
	}

	public static String getEntryFromScore(Objective o, int score) {

		if (o == null) return null;
		if (!hasScoreTaken(o, score)) return null;
		for (String s : o
				.getScoreboard()
				.getEntries()) {
			if (o
					    .getScore(s)
					    .getScore() == score) return o
					.getScore(s)
					.getEntry();
		}
		return null;
	}

	public static boolean hasScoreTaken(Objective o, int score) {

		for (String s : o
				.getScoreboard()
				.getEntries()) {
			if (o
					    .getScore(s)
					    .getScore() == score) return true;
		}
		return false;
	}

	public static void replaceScore(Objective o, int score, String name) {

		if (hasScoreTaken(o, score)) {
			if (getEntryFromScore(o, score).equalsIgnoreCase(name)) return;
			if (!(getEntryFromScore(o, score).equalsIgnoreCase(name)))
				o
						.getScoreboard()
						.resetScores(getEntryFromScore(o, score));
		}
		o
				.getScore(name)
				.setScore(score);
	}

}
