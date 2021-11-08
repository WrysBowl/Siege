package net.siegerpg.siege.core.drops;

import org.bukkit.inventory.ItemStack;

public class Reward {
    ItemStack item;
    double chance;
    public Reward(ItemStack item, double chance) {
        this.item = item;
        this.chance = chance;
    }

    public double getChance() {
        return chance;
    }

    public ItemStack getItem() {
        return item;
    }
}
