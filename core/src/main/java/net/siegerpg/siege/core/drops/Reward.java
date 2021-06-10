package net.siegerpg.siege.core.drops;

import org.bukkit.inventory.ItemStack;

public class Reward {
    ItemStack item = null;
    double chance = 0;
    Reward(ItemStack itemInput, double chanceInput) {
        this.item = itemInput;
        this.chance = chanceInput;
    }
}
