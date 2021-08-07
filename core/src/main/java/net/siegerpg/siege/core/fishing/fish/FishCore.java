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

import javax.annotation.Nullable;
import java.util.ArrayList;

public class FishCore {

	public static void refreshFishList() {
		registeredFish.clear();
		registeredFish = new ArrayList<>() {
			{
				add(new Bearacuda());
				add(new BigBlueTuna());
				add(new Catastrophe());
				add(new Codzilla());
				add(new FlashyShark());
				add(new MrKrabs());
				add(new MrsPuff());
				add(new PistolWhipper());
				add(new RedSnacker());
				add(new StingWhip());
			}
		};
	}

	public static ArrayList<Fish> registeredFish = new ArrayList<>() {
		{
			add(new Bearacuda());
			add(new BigBlueTuna());
			add(new Catastrophe());
			add(new Codzilla());
			add(new FlashyShark());
			add(new MrKrabs());
			add(new MrsPuff());
			add(new PistolWhipper());
			add(new RedSnacker());
			add(new StingWhip());
		}
	};

	public static Fish chooseRandomFish(@Nullable BaitCore baitCore, Player player) {
		double totalWeight = 0;
		refreshFishList(); //makes new instances of fish
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

	public static Double getRandomSize(Fish fish) {
		double min = fish.size[0];
		double max = fish.size[1];
		return min + (int)(Math.random() * (max - min));
	}

	public static ItemStack getItem(Fish fish) {
		ItemStack item = new ItemStack(Material.COD);
		ItemMeta meta = item.getItemMeta();
		meta.displayName(Utils.lore("<yellow>"+fish.name));
		meta.lore(new ArrayList<>(){
			{
				add(Utils.lore("<yellow>Size <gray>"+ fish.actualSize+" cm"));
			}
		});
		item.setItemMeta(meta);
		NBTItem nbtItem = new NBTItem(item);
		nbtItem.setInteger("CustomModelData", fish.customModelData);
		nbtItem.setString("Name", fish.name);
		return nbtItem.getItem();
	}
}
