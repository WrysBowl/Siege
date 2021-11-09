package net.siegerpg.siege.core.drops.mobs.hillyWoods.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;

public class Wooly extends MobDropTable {
    public Wooly() {
        super("Wooly", 10, 13, 8, 11, new Reward[]{
                new Reward(Wool.Companion.tier(1).getUpdatedItem(false), 100.0),
                new Reward(Wool.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(Wool.Companion.tier(3).getUpdatedItem(false), 1.0),
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 80.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 8.0),

                new Reward(new Drumstick(50).getUpdatedItem(false), 25.0),
        });
    }
}