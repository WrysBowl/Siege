package net.siegerpg.siege.core.drops;

import org.bukkit.inventory.ItemStack;

public class Reward {
    ItemStack item;
    double chance;
    public Reward(final ItemStack item, final double chance) {
        this.item = item;
        this.chance = chance;
    }
}
