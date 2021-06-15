package net.siegerpg.siege.core.fishing.fishes.types;

import net.siegerpg.siege.core.fishing.fishes.Fish;
import net.siegerpg.siege.core.fishing.fishes.FishLevel;

public class BlackDrumFish extends Fish {

	// THIS IS AN EXAMPLE FISH CLASS
	public BlackDrumFish(){
		super(new FishLevel(new double[] {3, 5}, 15, 0.5, 15, 10, 5), "BlackDrum");
	}
}
