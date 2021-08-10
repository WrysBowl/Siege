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
	
	public BaitCore (BaitStats[] stats, String baitName, Material material) {
		this.baitName=baitName;
		for(BaitStats stat : stats) {
			this.stats.add(stat);
		}
		ItemStack item = new ItemStack(material);
		NBTItem nbt = new NBTItem(item);
		nbt.setString("baitType", baitName);
		item = nbt.getItem();
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + baitName + " bait");
		meta.lore(new ArrayList<>(){
			{
				add(Utils.lore("<yellow>Hold in off-hand to use"));

			}
		});
		item.setItemMeta(meta);
		this.baitItemStack = item;
	}





	public static void registerAllBaits() {
		baits.add(new BigBlueTunaBait());
		baits.add(new FlashySharkBait());
		baits.add(new BearacudaBait());
	}

	public static BaitCore getBait(String name) {
		for(BaitCore bait : baits) {
			if(bait.getName().equalsIgnoreCase(name))
				return bait;
		}
		return null;
	}

	public static boolean hasBait(String name) {
		for(BaitCore bait : baits) {
			if(bait.getName().equals(name))
				return true;
		}
		return false;
	}

	public boolean hasFish(String name) {
		for(BaitStats stats : this.stats) {
			if(stats.getFish().name.equalsIgnoreCase(name))
				return true;
		}
		return false;
	}




	public ArrayList<BaitStats> getStats() {
		return stats;
	}

	public void setStats(ArrayList<BaitStats> stats) {
		this.stats = stats;
	}

	public BaitStats getStat(String name) {
		for(BaitStats stats : this.stats) {
			if(stats.getFish().name.equalsIgnoreCase(name))
				return stats;
		}
		return null;
	}

	public ItemStack getBaitItemStack() {
		return baitItemStack;
	}

	public void setBaitItemStack(ItemStack baitItemStack) {
		this.baitItemStack = baitItemStack;
	}

	public String getName() {
		return baitName;
	}

	public void setName(String baitName) {
		this.baitName = baitName;
	}
}
