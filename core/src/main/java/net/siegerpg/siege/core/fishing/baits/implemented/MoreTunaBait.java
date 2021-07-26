package net.siegerpg.siege.core.fishing.baits.implemented;

import net.siegerpg.siege.core.fishing.baits.BaitCore;
import net.siegerpg.siege.core.fishing.baits.BaitStats;
import net.siegerpg.siege.core.fishing.fish.implemented.BigBlueTuna;
import org.bukkit.Material;

public class MoreTunaBait extends BaitCore {

	// THIS IS AN EXAMPLE BAIT
	public MoreTunaBait() {
		super(new BaitStats[]{new BaitStats(new BigBlueTuna(), 1000)}, "MoreTuna", Material.SEA_PICKLE);
	}




}
