package net.siegerpg.siege.core.fishing.catches.loot.webstore;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.webstore.categories.boosters.GOLDBooster_50;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GOLD50 extends Fish {

	public GOLD50 () {
		super(60, 0.9, 12, 15,
				new GOLDBooster_50().getBoosterItem());
	}

	@Override
	public void accomplishment (Player player) {
		Bukkit.getServer().sendMessage(Utils.lore("<green>" + player.getName() + " has found a <yellow>50% GOLD Booster<green> from fishing!"));
	}
}
