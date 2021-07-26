package net.siegerpg.siege.core.fishing.fish;

import de.tr7zw.nbtapi.NBTItem;
import net.siegerpg.siege.core.fishing.baits.BaitCore;
import net.siegerpg.siege.core.fishing.baits.BaitStats;
import net.siegerpg.siege.core.fishing.fish.implemented.*;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class FishCore {

	public static ArrayList<Fish> registeredFish = new ArrayList<>() {
		{
			add(new Bearacuda());
			add(new PistolWhipper());
		}
	};

	public static Fish chooseRandomFish(@Nullable BaitCore baitCore, Player player) {
		double totalWeight = 0;
		for (Fish fish : registeredFish) {
			totalWeight += fish.chance;
			if (baitCore == null)
				continue;
			if (baitCore.hasFish(fish.name)) {
				player.sendMessage(baitCore.getName() + "added 1");
				BaitStats stats = baitCore.getStat(fish.name);
				double stat = stats.getChanceAdded();
				totalWeight += stat;
			}

		}
		int weight = 0;
		double random = Math.random() * totalWeight;
		for (Fish fish : registeredFish) {
			if (baitCore != null && baitCore.hasFish(fish.name)) {
				BaitStats stats = baitCore.getStat(fish.name);
				double stat = stats.getChanceAdded();
				weight += stat;
			}
			weight += fish.chance;
			if (random > weight) continue; //if the random number is above the totalWeight
			return fish;
		}
		return registeredFish.get(0);
	}

	public static Fish getFish(String name) {
		for(Fish fish : registeredFish) {
			if(!fish.name.equals(name)) continue;
			return fish;
		}
		return null;
	}

	public static ItemStack getItem(Fish fish) {
		ItemStack item = new ItemStack(Material.COD);
		ItemMeta meta = item.getItemMeta();
		meta.displayName(Utils.lore("<yellow>"+fish.name+" <gray>"+ fish.actualSize));
		meta.lore(new ArrayList<>(){
			{
				add(Utils.lore("  <gray>Size: <white>" + fish.actualSize));
			}
		});

		item.setItemMeta(meta);
		NBTItem nbtItem = new NBTItem(item);
		nbtItem.setInteger("CustomModelData", fish.customModelData);
		return nbtItem.getItem();
	}
}
