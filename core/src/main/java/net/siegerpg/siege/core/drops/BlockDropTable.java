package net.siegerpg.siege.core.drops;

import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BlockDropTable implements Listener {
    int blockRegen;
    Material material;
    int goldMin;
    int goldMax;
    int expMin;
    int expMax;
    Reward[] rewards;

    public BlockDropTable(final int blockRegen, final Material material, final int goldMin, final int goldMax, final int expMin, final int expMax, final Reward[] rewards) {
        this.blockRegen = blockRegen;
        this.material = material;
        this.goldMin = goldMin;
        this.goldMax = goldMax;
        this.expMin = expMin;
        this.expMax = expMax;
        this.rewards = rewards;
    }

    public Integer getBlockRegen() {
        return this.blockRegen;
    }
    public Material getMaterial() {
        return this.material;
    }
    public ArrayList<ItemStack> getRewards(final double luckChance) {
        final ArrayList<ItemStack> itemList = new ArrayList<>();
        for (final Reward reward : this.rewards) {
            if (!Utils.randTest(reward.chance)) continue;
            for (double i=luckChance; i>=0;i-=100) {
                itemList.add(reward.item);
                if (i <= 100 && Utils.randTest(i)) {
                    itemList.add(reward.item);
                }
            }
        }
        return itemList;
    }
    public Integer getGold(final boolean rand) {
        if (rand) {
            return (int) Math.floor(Math.random()*(this.goldMax - this.goldMin +1)+ this.goldMin);
        }
        return this.goldMax;
    }
    public Integer getExp(final boolean rand) {
        if (rand) {
            return (int) Math.floor(Math.random()*(this.expMax - this.expMin +1)+ this.expMin);
        }
        return this.expMax;
    }
}
