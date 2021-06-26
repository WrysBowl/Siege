package net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;

public class ChestMimic2 extends MobDropTable {
    public ChestMimic2() {
        super("ChestMimic", 150, 300, 150, 300, new Reward[]{
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(new Drumstick(100).getUpdatedItem(false), 5.0),
                new Reward(new Drumstick(50).getUpdatedItem(false), 25.0)
        });
    }
}