package net.siegerpg.siege.core.miscellaneous.cache;

import org.bukkit.entity.*;

public class GlobalMultipliers {

	public static double expMultiplier = 1.0;
	public static double goldMultiplier = 1.0;

	public static double getEXPMultipliers(Player player) {

		double exp = expMultiplier;

		if (player.hasPermission("group.hero")) {
			exp *= 1.1;
		} else if (player.hasPermission("group.gladiator")) {
			exp *= 1.075;

		} else if (player.hasPermission("group.warrior")) {
			exp *= 1.05;

		}
		return exp;

	}

	public static double getGoldMultipliers(Player player) {

		double gold = goldMultiplier;

		if (player.hasPermission("group.hero")) {
			gold *= 1.1;
		} else if (player.hasPermission("group.gladiator")) {
			gold *= 1.075;

		} else if (player.hasPermission("group.warrior")) {
			gold *= 1.05;

		}
		return gold;

	}

}
