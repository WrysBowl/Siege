package net.siegerpg.siege.core.fishing.baits;

import net.siegerpg.siege.core.fishing.fish.FishCore;

public class BaitStats {
	
	
	private FishCore fish;
	private int chanceAdded;
	
	public BaitStats (String fishName, int chanceAdded) {
		FishCore fish = FishCore.getFish(fishName);
		this.fish=fish;
		this.chanceAdded=chanceAdded;
		
	}


	public FishCore getFish() {
		return fish;
	}

	public void setFish(FishCore fish) {
		this.fish = fish;
	}

	public int getChanceAdded() {
		return chanceAdded;
	}

	public void setChanceAdded(int chanceAdded) {
		this.chanceAdded = chanceAdded;
	}

}
