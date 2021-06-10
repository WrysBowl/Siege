package net.siegerpg.siege.core.drops.blocks;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Stone extends BlockDropTable {
    int blockRegen = 100;
    Material material = Material.STONE;
    int goldMin = 0;
    int goldMax = 1;
    int expMin = 0;
    int expMax = 0;
    Reward[] rewards = new Reward[]{
            new Reward(Pebble.Companion.tier(1).getUpdatedItem(false), 100.0),
            new Reward(Pebble.Companion.tier(2).getUpdatedItem(false), 10.0),
            new Reward(Pebble.Companion.tier(3).getUpdatedItem(false), 0.1)
    };

    Stone(int blockRegen, Material material, int goldMin, int goldMax, int expMin, int expMax, Reward[] rewards) {
        super(blockRegen, material, goldMin, goldMax, expMin, expMax, rewards);
    }
}
