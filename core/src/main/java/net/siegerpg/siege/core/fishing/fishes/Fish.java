package net.siegerpg.siege.core.fishing.fishes;

import net.siegerpg.siege.core.fishing.fishes.types.BlackDrumFish;
import net.siegerpg.siege.core.fishing.fishes.types.TunaFish;

import java.util.ArrayList;

public abstract class Fish {
	
	public static ArrayList<Fish> fishTypes = new ArrayList<Fish>();
	
	private FishLevel level;
	private String fishType;
	
	public Fish(FishLevel level, String fishType) {
		this.level=level;
		this.fishType=fishType;
	}
	
	
	public static void registerFishes() {
		fishTypes.add(new TunaFish());
		fishTypes.add(new BlackDrumFish());
	}
	
	public static Fish chooseRandomFish() {
		double totalWeight = 0;
		for(Fish fish : Fish.fishTypes) {
		    totalWeight += fish.getLevel().chance;
		}
		int randomIndex = -1;
		double random = Math.random() * totalWeight;
		for (int i = 0; i < Fish.fishTypes.size(); ++i)
		{
		    random -= Fish.fishTypes.get(i).getLevel().chance;
		    if (random <= 0.0d)
		    {
		        randomIndex = i;
		        break;
		    }
		}
		return Fish.fishTypes.get(randomIndex);
	}
	
	
	

	public FishLevel getLevel() {
		return level;
	}

	public String getFishName() {
		return this.fishType;
	}

}
