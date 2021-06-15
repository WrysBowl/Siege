package net.siegerpg.siege.core.fishing.fishes.types;

import net.siegerpg.siege.core.fishing.fishes.Fish;
import net.siegerpg.siege.core.fishing.fishes.FishLevel;

public class TunaFish extends Fish {

	// THIS IS AN EXAMPLE FISH CLASS
	public TunaFish() {
		super(new FishLevel(new double[] {5, 8}, 30, 0.2, 10, 1, 0), "Tuna");
	}

}
