package net.siegerpg.siege.core.fishing.fish;

import net.siegerpg.siege.core.fishing.baits.BaitCore;
import net.siegerpg.siege.core.fishing.baits.BaitStats;
import net.siegerpg.siege.core.fishing.fish.implemented.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public abstract class FishCore {
	
	public static ArrayList<FishCore> fishCoreTypes = new ArrayList<FishCore>();
	
	private FishStats level;
	private String fishType;

	
	public FishCore(FishStats level, String fishType) {
		this.level=level;
		this.fishType=fishType;
	}

	public static void registerAllFishes() {
		fishCoreTypes.add(new Tuna());
		fishCoreTypes.add(new BlackDrum());
		fishCoreTypes.add(new Bearacuda());
		fishCoreTypes.add(new BigBlueTuna());
		fishCoreTypes.add(new Catastrophe());
		fishCoreTypes.add(new Codzilla());
		fishCoreTypes.add(new FlashyShark());
		fishCoreTypes.add(new MrKrabs());
		fishCoreTypes.add(new MrsPuff());
		fishCoreTypes.add(new PistolWhipper());
		fishCoreTypes.add(new RedSnacker());
		fishCoreTypes.add(new StingWhip());
	}

	
	public static FishCore chooseRandomFish(BaitCore baitCore, Player player) {
		double totalWeight = 0;
		for(FishCore fishCore : FishCore.fishCoreTypes) {
		    totalWeight += fishCore.getLevel().chance ;
		    if(baitCore == null)
		    	continue;
		    if (baitCore.hasFish(fishCore.getFishName())) {
				player.sendMessage(baitCore.getName() + "added 1");
				BaitStats stats =baitCore.getStat(fishCore.getFishName());
				double stat = stats.getChanceAdded();
				totalWeight += stat;
			}

		}
		int randomIndex = -1;
		double random = Math.random() * totalWeight;
		for (int i = 0; i < FishCore.fishCoreTypes.size(); ++i)
		{
			FishCore fish = FishCore.fishCoreTypes.get(i);
		    random -= fish.getLevel().chance;
			if (baitCore != null && baitCore.hasFish(fish.getFishName())) {
				player.sendMessage(baitCore.getName() + "added 2");
				BaitStats stats =baitCore.getStat(fish.getFishName());
				double stat = stats.getChanceAdded();
				random -= stat;
			}
		    if (random <= 0.0d)
		    {
		        randomIndex = i;
		        break;
		    }
		}
		return FishCore.fishCoreTypes.get(randomIndex);
	}


	public static FishCore getFish(String name) {
		for(FishCore fish : fishCoreTypes) {
			if(fish.getFishName()== name)
			{
				return fish;
			}
		}
		return null;
	}
	
	

	public FishStats getLevel() {
		return level;
	}

	public String getFishName() {
		return this.fishType;
	}

}
