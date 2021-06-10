package net.siegerpg.siege.core.drops;

import org.bukkit.Material;

public class BlockDropTable implements DropTable {
    int blockRegen = 20;
    Material material = null;
    int goldMin = 0;
    int goldMax = 0;
    int expMin = 0;
    int expMax = 0;
    Reward[] rewards;

    BlockDropTable(int blockRegen, Material material, int goldMin, int goldMax, int expMin, int expMax, Reward[] rewards) {
        this.blockRegen = blockRegen;
        this.material = material;
        this.goldMin = goldMin;
        this.goldMax = goldMax;
        this.expMin = expMin;
        this.expMax = expMax;
        this.rewards = rewards;
    }
}
