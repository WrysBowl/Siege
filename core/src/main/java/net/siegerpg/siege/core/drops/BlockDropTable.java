package net.siegerpg.siege.core.drops;

import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class BlockDropTable implements Listener {
    int blockRegen;
    Material material;
    int goldMin;
    int goldMax;
    int expMin;
    int expMax;
    Reward[] rewards;

    public BlockDropTable(int blockRegen, Material material, int goldMin, int goldMax, int expMin, int expMax, Reward[] rewards) {
        this.blockRegen = blockRegen;
        this.material = material;
        this.goldMin = goldMin;
        this.goldMax = goldMax;
        this.expMin = expMin;
        this.expMax = expMax;
        this.rewards = rewards;
    }

    public Integer getBlockRegen() {
        return blockRegen;
    }
    public Material getMaterial() {
        return material;
    }
    public ArrayList<ItemStack> getRewards(double luckChance) {
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
    public Integer getGold(boolean rand) {
        if (rand) {
            double randomGold = (Math.random() * goldMax) + goldMin;
            return (int) Math.round(randomGold);
        }
        return goldMax;
    }
    public Integer getExp(boolean rand) {
        if (rand) {
            double randomExp = (Math.random() * expMax) + expMin;
            return (int) Math.round(randomExp);
        }
        return expMax;
    }
}
