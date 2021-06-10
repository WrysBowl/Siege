package net.siegerpg.siege.core.drops;

import org.bukkit.Material;

public class MobDropTable implements DropTable {
    String mobName = "";
    int goldMin = 0;
    int goldMax = 0;
    int expMin = 0;
    int expMax = 0;
    Reward[] rewards;

    MobDropTable(String mobName, int goldMin, int goldMax, int expMin, int expMax, Reward[] rewards) {
        this.mobName = mobName;
        this.goldMin = goldMin;
        this.goldMax = goldMax;
        this.expMin = expMin;
        this.expMax = expMax;
        this.rewards = rewards;
    }
}