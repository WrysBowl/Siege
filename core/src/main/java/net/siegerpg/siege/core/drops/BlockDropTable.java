package net.siegerpg.siege.core.drops;

import org.bukkit.Material;
import org.bukkit.event.Listener;

public class BlockDropTable implements DropTable, Listener {
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
}
