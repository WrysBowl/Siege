package net.siegerpg.siege.core.fishing.fish;

import net.siegerpg.siege.core.fishing.fish.implemented.BlackDrumFish;
import net.siegerpg.siege.core.fishing.fish.implemented.TunaFish;

import java.util.ArrayList;

public abstract class FishCore {
	
	public static ArrayList<FishCore> fishTypes = new ArrayList<FishCore>();
	
	private Fish level;
	private String fishType;
	
	
	public FishCore(Fish level, String fishType) {
		this.level=level;
		this.fishType=fishType;
	}

	public static void registerFish() {
		fishTypes.add(new TunaFish());
		fishTypes.add(new BlackDrumFish());
	}
	
	public static FishCore chooseRandomFish() {
		double totalWeight = 0;
		for(FishCore fish : FishCore.fishTypes) {
		    totalWeight += fish.getLevel().chance;
		}
		int randomIndex = -1;
		double random = Math.random() * totalWeight;
		for (int i = 0; i < FishCore.fishTypes.size(); ++i)
		{
		    random -= FishCore.fishTypes.get(i).getLevel().chance;
		    if (random <= 0.0d)
		    {
		        randomIndex = i;
		        break;
		    }
		}
		return FishCore.fishTypes.get(randomIndex);
	}
	
	
	

	public Fish getLevel() {
		return level;
	}

	public String getFishName() {
		return this.fishType;
	}

}
