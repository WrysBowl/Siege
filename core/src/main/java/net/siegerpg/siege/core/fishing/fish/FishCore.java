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
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class FishCore {

    public static void refreshFishList() {
	    FishCore.registeredFish.clear();
	    FishCore.registeredFish = new ArrayList<>() {
            {
	            this.add(new Bearacuda());
	            this.add(new BigBlueTuna());
	            this.add(new Catastrophe());
	            this.add(new Codzilla());
	            this.add(new FlashyShark());
	            this.add(new MrKrabs());
	            this.add(new MrsPuff());
	            this.add(new PistolWhipper());
	            this.add(new RedSnacker());
	            this.add(new StingWhip());
            }
        };
    }

    public static ArrayList<Fish> registeredFish = new ArrayList<>() {
        {
	        this.add(new Bearacuda());
	        this.add(new BigBlueTuna());
	        this.add(new Catastrophe());
	        this.add(new Codzilla());
	        this.add(new FlashyShark());
	        this.add(new MrKrabs());
	        this.add(new MrsPuff());
	        this.add(new PistolWhipper());
	        this.add(new RedSnacker());
	        this.add(new StingWhip());
        }
    };

    public static Fish chooseRandomFish(@Nullable final BaitCore baitCore, final Player player) {
        double totalWeight = 0;
	    FishCore.refreshFishList(); //makes new instances of fish
        for (final Fish fish : FishCore.registeredFish) {
            totalWeight += fish.chance;
            if (baitCore == null)
                continue;
            if (baitCore.hasFish(fish.name)) {
                player.sendMessage(baitCore.getName() + "added 1");
                final BaitStats stats = baitCore.getStat(fish.name);
                final double stat = stats.getChanceAdded();
                totalWeight += stat;
            }

        }
        int weight = 0;
        final double random = Math.random() * totalWeight;
        for (final Fish fish : FishCore.registeredFish) {
            if (baitCore != null && baitCore.hasFish(fish.name)) {
                final BaitStats stats = baitCore.getStat(fish.name);
                final double stat = stats.getChanceAdded();
                weight += stat;
            }
            weight += fish.chance;
            if (random > weight) continue; //if the random number is above the totalWeight
            return fish;
        }
        return FishCore.registeredFish.get(0);
    }

    public static Fish getFish(final String name) {
        for (final Fish fish : FishCore.registeredFish) {
            if (!fish.name.equals(name)) continue;
            return fish;
        }
        return null;
    }

    public static Double getRandomSize(final Fish fish) {
        final double min = fish.size[0];
        final double max = fish.size[1];
        return min + (int) (Math.random() * (max - min));
    }

    public static ItemStack getItem(final Fish fish) {
        final ItemStack item = new ItemStack(Material.COD);
        final ItemMeta meta = item.getItemMeta();
        meta.displayName(Utils.lore("<yellow>" + fish.name));
        meta.lore(new ArrayList<>() {
            {
	            this.add(Utils.lore("<yellow>Size <gray>" + fish.actualSize + " cm"));
            }
        });
        item.setItemMeta(meta);
        final NBTItem nbtItem = new NBTItem(item);
        nbtItem.setInteger("CustomModelData", fish.customModelData);
        nbtItem.setString("Name", fish.name);
        return nbtItem.getItem();
    }
}
