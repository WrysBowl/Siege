package net.siegerpg.siege.core.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GoldEXPSpawning {

    public static ItemStack getGoldCoin(final Integer amount) {
        final ItemStack gold = new ItemStack(Material.SUNFLOWER);
        final ItemMeta meta = gold.getItemMeta();
        meta.setDisplayName("Gold Coin");
        if (amount > 0) {
            gold.setAmount(amount);
        }
        gold.setItemMeta(meta);
        return gold;
    }

    public static void spawnGold(final int goldCoinAmt, final Location loc) {
        final ItemStack goldCoin = GoldEXPSpawning.getGoldCoin(goldCoinAmt);
        final Item gold = loc.getWorld().dropItemNaturally(loc, goldCoin);
        gold.setCustomName(Utils.tacc("&e+" + goldCoinAmt + " Gold"));
        gold.setCustomNameVisible(true);
    }
    public static void spawnEXP(final int exp, final Location loc) {
        final ExperienceOrb orb = loc.getWorld().spawn(loc, ExperienceOrb.class);
        orb.setCustomName(Utils.tacc("&5+" + exp + " EXP"));
        orb.setExperience(exp);
        orb.setCustomNameVisible(true);
    }
}
