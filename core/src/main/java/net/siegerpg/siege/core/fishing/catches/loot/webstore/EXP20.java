package net.siegerpg.siege.core.fishing.catches.loot.webstore;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.webstore.categories.boosters.EXPBooster_20;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class EXP20 extends Fish {

	public EXP20 () {
		super(40, 0.8, 15, 15,
				new EXPBooster_20().getBoosterItem());
	}

	@Override
	public void accomplishment (Player player) {
		Bukkit.getServer().sendMessage(Utils.lore("<green>" + player.getName() + " has found a <purple>20% EXP Booster<green> from fishing!"));
	}
}
