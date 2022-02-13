package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.FishStats;

public class Tuna extends FishCore {

	// THIS IS AN EXAMPLE FISH CLASS
	public Tuna() {
		super(new FishStats(new double[] {5, 8}, 30, 0.2, 10, 1, 0), "Tuna");
	}

}
