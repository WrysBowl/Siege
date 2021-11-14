package net.siegerpg.siege.core.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GoldEXPSpawning {

    public static ItemStack getGoldCoin(Integer amount) {
        ItemStack gold = new ItemStack(Material.SUNFLOWER);
        ItemMeta meta = gold.getItemMeta();
        meta.setDisplayName("Gold Coin");
        if (amount > 0) {
            gold.setAmount(amount);
        }
        gold.setItemMeta(meta);
        return gold;
    }

    public static void spawnGold(int goldCoinAmt, Location loc) {
        ItemStack goldCoins = getGoldCoin(1);
        Item gold = loc.getWorld().dropItemNaturally(loc, goldCoins);
        gold.getItemStack().setAmount(goldCoinAmt);
        gold.setCustomName(Utils.tacc("&e+" + String.format("%,d", goldCoinAmt) + " Gold"));
        gold.setCustomNameVisible(true);
    }
    public static void spawnEXP(int exp, Location loc) {
        ExperienceOrb orb = loc.getWorld().spawn(loc, ExperienceOrb.class);
        orb.setCustomName(Utils.tacc("&d+" + String.format("%,d", exp) + " EXP"));
        orb.setExperience(exp);
        orb.setCustomNameVisible(true);
    }
}
