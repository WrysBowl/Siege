package net.siegerpg.siege.core.miscellaneous;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GoldEXPSpawning {

	public static ItemStack getGoldCoin(Integer amount) {

		ItemStack gold = new ItemStack(Material.SUNFLOWER);
		ItemMeta meta = gold.getItemMeta();
		meta.setDisplayName("\u26C1");
		if (amount > 0) {
			gold.setAmount(amount);
		}
		gold.setItemMeta(meta);
		return gold;
	}

	public static void spawnGold(int goldCoinAmt, Location loc) {

		ItemStack goldCoins = getGoldCoin(1);
		Item gold = loc
				.getWorld()
				.dropItemNaturally(loc, goldCoins);
		gold
				.getItemStack()
				.setAmount(goldCoinAmt);
		gold.setCustomName(Utils.tacc("&e" + String.format("%,d", goldCoinAmt) + " \u26C1"));
		gold.setCustomNameVisible(true);
	}

	public static void spawnEXP(int exp, Location loc) {

		ExperienceOrb orb = loc
				.getWorld()
				.spawn(loc, ExperienceOrb.class);
		orb.setCustomName(Utils.tacc("&d+" + String.format("%,d", exp) + " \u2742"));
		orb.setExperience(exp);
		orb.setCustomNameVisible(true);
	}

}
