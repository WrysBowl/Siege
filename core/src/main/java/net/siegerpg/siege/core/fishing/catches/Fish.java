package net.siegerpg.siege.core.fishing.catches;

import de.tr7zw.nbtapi.NBTItem;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Fish {

	public String name = "";
	public double[] size = null;
	public double moveSpeed = 0;
	public int length = 0;
	public double chanceToChangeDirection = 0;
	public double winScore = 0;
	public int customModelData = 0;
	public double actualSize = 0;
	public ItemStack item = null;

	/*
	 * chanceToChangeDirection is in percentile,
	 * moveSpeed ex: 0,5 means it moves 0,5 character for every 2 tick(1 every 4 ticks) - 0,2 = moves 0,2 characters every 0,2 ticks (1 every 10 tick)
	 * winScore you get 1 per second in the green and the win score is the max to win
	 * */
	public Fish (String name, double[] size, double winScore, double moveSpeed, int length,
	             double chanceToChangeDirection, int customModelData) {

		this.name = name;
		this.chanceToChangeDirection = chanceToChangeDirection;
		this.length = length;
		this.size = size;
		this.moveSpeed = moveSpeed;
		this.winScore = winScore;
		this.customModelData = customModelData;
		this.actualSize = getRandomSize();
	}

	public Fish (double winScore, double moveSpeed, int length,
	             double chanceToChangeDirection, ItemStack item) {

		this.chanceToChangeDirection = chanceToChangeDirection;
		this.length = length;
		this.moveSpeed = moveSpeed;
		this.winScore = winScore;
		this.item = item;
	}

	public void accomplishment (Player player) {

	}

	public Double getRandomSize () {

		double min = this.size[0];
		double max = this.size[1];
		return min + (int) (Math.random() * (max - min));
	}

	public ItemStack getItem () {

		if (item != null) return item;
		ItemStack item = new ItemStack(Material.COD);
		ItemMeta meta = item.getItemMeta();
		meta.displayName(Utils.lore("<yellow>" + this.name));
		meta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<yellow>Size <gray>" + actualSize + " cm"));
				add(Utils.lore(""));
				add(Utils.lore("<gray>Right click <gold>Henry Fisher"));
				add(Utils.lore("<gray>to sell the fish in your hand!"));
			}
		});
		item.setItemMeta(meta);
		NBTItem nbtItem = new NBTItem(item);
		nbtItem.setInteger("CustomModelData", this.customModelData);
		nbtItem.setString("Name", this.name);
		return nbtItem.getItem();
	}

}
