package net.siegerpg.siege.core.drops;

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

    ArrayList<ItemStack> getRewards(double luckChance) {
        ArrayList<ItemStack> itemList = new ArrayList<>();
        for (Reward reward : rewards) {
            if (Utils.randTest(reward.chance)) {
                if ((Math.random() * 100) <= luckChance) {
                    itemList.add(reward.item);
                }
                itemList.add(reward.item);
            }
        }
        return itemList;
    }
    Integer getGold(boolean rand) {
        if (rand) {
            double randomGold = (Math.random() * goldMax) + goldMin;
            return (int) Math.round(randomGold);
        }
        return goldMax;
    }
    Integer getExp(boolean rand) {
        if (rand) {
            double randomExp = (Math.random() * expMax) + expMin;
            return (int) Math.round(randomExp);
        }
        return expMax;
    }
}
