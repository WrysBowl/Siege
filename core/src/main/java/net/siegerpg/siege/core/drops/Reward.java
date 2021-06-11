package net.siegerpg.siege.core.drops;

import org.bukkit.inventory.ItemStack;

public class Reward {
    ItemStack item = null;
    double chance = 0;
    public Reward(ItemStack item, double chance) {
        this.item = item;
        this.chance = chance;
    }
}
