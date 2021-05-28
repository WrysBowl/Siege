package net.siegerpg.siege.core.utils;

import net.siegerpg.siege.core.Webstore.WebstoreUtils;
import org.bukkit.Location;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class GoldEXPSpawning {
    public static void spawnGold(int goldCoinAmt, Location loc) {
        ItemStack goldCoin = Utils.getGoldCoin(goldCoinAmt);
        Item gold = loc.getWorld().dropItemNaturally(loc, goldCoin);
        gold.setCustomName(Utils.tacc("&e+" + goldCoinAmt + " Gold"));
        gold.setCustomNameVisible(true);
    }
    public static void spawnEXP(int exp, Location loc) {
        ExperienceOrb orb = loc.getWorld().spawn(loc, ExperienceOrb.class);
        orb.setCustomName(Utils.tacc("&5+" + exp + " EXP"));
        orb.setExperience(exp);
        orb.setCustomNameVisible(true);
    }
}
