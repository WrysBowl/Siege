package net.siegerpg.siege.core.drops;

interface DropTable {
    int goldMin = 0;
    int goldMax = 0;
    int expMin = 0;
    int expMax = 0;
    Reward[] rewards = new Reward[]{null};
}
