package net.siegerpg.siege.core.drops;

import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

interface DropTable {
    int goldMin = 0;
    int goldMax = 0;
    int expMin = 0;
    int expMax = 0;
    Reward[] rewards = null;

    default ArrayList<ItemStack> getRewards(double luckChance) {
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
    default Integer getGold(boolean rand) {
        if (rand) {
            double randomGold = (Math.random() * goldMax) + goldMin;
            return (int) Math.round(randomGold);
        }
        return goldMax;
    }
    default Integer getExp(boolean rand) {
        if (rand) {
            double randomExp = (Math.random() * expMax) + expMin;
            return (int) Math.round(randomExp);
        }
        return expMax;
    }
}
