package net.siegerpg.siege.core.fishing.baits;

import net.siegerpg.siege.core.fishing.fish.Fish;
import net.siegerpg.siege.core.fishing.fish.FishCore;

public class BaitStats {
	
	
	private Fish fish;
	private int chanceAdded;
	
	public BaitStats (Fish fish, int chanceAdded) {
		this.fish=fish;
		this.chanceAdded=chanceAdded;
		
	}


	public Fish getFish() {
		return fish;
	}

	public void setFish(Fish fish) {
		this.fish = fish;
	}

	public int getChanceAdded() {
		return chanceAdded;
	}

	public void setChanceAdded(int chanceAdded) {
		this.chanceAdded = chanceAdded;
	}

}
