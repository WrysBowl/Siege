package net.siegerpg.siege.core.fishing.fish;

import de.tr7zw.nbtapi.NBTItem;
import net.siegerpg.siege.core.fishing.baits.BaitCore;
import net.siegerpg.siege.core.fishing.baits.BaitStats;
import net.siegerpg.siege.core.fishing.fish.implemented.*;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class FishCore {
	
	public static ArrayList<FishCore> fishCoreTypes = new ArrayList<FishCore>();
	
	private Fish level;
	private String fishType;

	
	public FishCore(Fish level, String fishType) {
		this.level=level;
		this.fishType=fishType;
	}

	public static HashMap<String, Fish> registeredFish = new HashMap<String, Fish>(){
		{
			put("Bearacuda", new Bearacuda());
			put("Big Blue Tuna", new BigBlueTuna());
			put("BlackDrum", new BlackDrum());
			put("Catastrophe", new Catastrophe());
			put("Codzilla", new Codzilla());
			put("Flashy Shark", new FlashyShark());
			put("Mr. Krabs", new MrKrabs());
			put("Mrs. Puff", new MrsPuff());
			put("Pistol Whipper", new PistolWhipper());
			put("Red Snacker", new RedSnacker());
			put("Sting Whip", new StingWhip());
		}
	};

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

	public static ItemStack getItem(FishCore fish) {
		ItemStack item = new ItemStack(Material.COD);
		ItemMeta meta = item.getItemMeta();
		Fish stats = fish.getLevel();
		meta.displayName(Utils.lore("<yellow>"+fish.getFishName()));
		meta.lore(new ArrayList<>(){
			{
				add(Utils.lore("  <gray>Size: <white>" + fish));
			}
		});

		item.setItemMeta(meta);
		NBTItem nbtItem = new NBTItem(item);
		nbtItem.setInteger("CustomModelData", stats.customModelData);
		return nbtItem.getItem();
	}
	
	

	public Fish getLevel() {
		return level;
	}

	public String getFishName() {
		return this.fishType;
	}

}
