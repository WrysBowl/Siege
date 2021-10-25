package net.siegerpg.siege.core.fishing.baits;


import de.tr7zw.nbtapi.NBTItem;
import net.siegerpg.siege.core.fishing.baits.implemented.BearacudaBait;
import net.siegerpg.siege.core.fishing.baits.implemented.FlashySharkBait;
import net.siegerpg.siege.core.fishing.baits.implemented.BigBlueTunaBait;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BaitCore {

	public static ArrayList<BaitCore> baits = new ArrayList<BaitCore>() ;

	private ArrayList<BaitStats> stats = new ArrayList<>();
	private ItemStack baitItemStack;
	private String baitName;
	
	public BaitCore (final BaitStats[] stats, final String baitName, final Material material) {
		this.baitName=baitName;
		for(final BaitStats stat : stats) {
			this.stats.add(stat);
		}
		ItemStack item = new ItemStack(material);
		final NBTItem nbt = new NBTItem(item);
		nbt.setString("baitType", baitName);
		item = nbt.getItem();
		final ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + baitName);
		meta.lore(new ArrayList<>(){
			{
				this.add(Utils.lore("<yellow>Hold in off-hand to use"));

			}
		});
		item.setItemMeta(meta);
		baitItemStack = item;
	}





	public static void registerAllBaits() {
		BaitCore.baits.add(new BigBlueTunaBait());
		BaitCore.baits.add(new FlashySharkBait());
		BaitCore.baits.add(new BearacudaBait());
	}

	public static BaitCore getBait(final String name) {
		for(final BaitCore bait : BaitCore.baits) {
			if(bait.getName().equalsIgnoreCase(name))
				return bait;
		}
		return null;
	}

	public static boolean hasBait(final String name) {
		for(final BaitCore bait : BaitCore.baits) {
			if(bait.getName().equals(name))
				return true;
		}
		return false;
	}

	public boolean hasFish(final String name) {
		for(final BaitStats stats : stats) {
			if(stats.getFish().name.equalsIgnoreCase(name))
				return true;
		}
		return false;
	}




	public ArrayList<BaitStats> getStats() {
		return this.stats;
	}

	public void setStats(final ArrayList<BaitStats> stats) {
		this.stats = stats;
	}

	public BaitStats getStat(final String name) {
		for(final BaitStats stats : stats) {
			if(stats.getFish().name.equalsIgnoreCase(name))
				return stats;
		}
		return null;
	}

	public ItemStack getBaitItemStack() {
		return this.baitItemStack;
	}

	public void setBaitItemStack(final ItemStack baitItemStack) {
		this.baitItemStack = baitItemStack;
	}

	public String getName() {
		return this.baitName;
	}

	public void setName(final String baitName) {
		this.baitName = baitName;
	}
}
