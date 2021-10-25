package net.siegerpg.siege.core.fishing.baits;

import net.siegerpg.siege.core.fishing.fish.Fish;
import net.siegerpg.siege.core.fishing.fish.FishCore;

public class BaitStats {
	
	
	private Fish fish;
	private int chanceAdded;
	
	public BaitStats (final Fish fish, final int chanceAdded) {
		this.fish=fish;
		this.chanceAdded=chanceAdded;
		
	}


	public Fish getFish() {
		return this.fish;
	}

	public void setFish(final Fish fish) {
		this.fish = fish;
	}

	public int getChanceAdded() {
		return this.chanceAdded;
	}

	public void setChanceAdded(final int chanceAdded) {
		this.chanceAdded = chanceAdded;
	}

}
