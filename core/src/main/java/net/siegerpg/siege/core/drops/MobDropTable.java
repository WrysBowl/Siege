package net.siegerpg.siege.core.drops;

public class MobDropTable implements DropTable {
    String mobName;
    int goldMin;
    int goldMax;
    int expMin;
    int expMax;
    Reward[] rewards;

    public MobDropTable(String mobName, int goldMin, int goldMax, int expMin, int expMax, Reward[] rewards) {
        this.mobName = mobName;
        this.goldMin = goldMin;
        this.goldMax = goldMax;
        this.expMin = expMin;
        this.expMax = expMax;
        this.rewards = rewards;
    }

    public String getMobName() {
        return mobName;
    }
}