package net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.HillyWoodsDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;

public class ChestMimic1 extends MobDropTable {
    public ChestMimic1() {
        super("ChestMimic1", 150, 200, 450, 500, new Reward[]{
                new Reward(Slime.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 25.0),
                new Reward(Stick.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 25.0),
                new Reward(Vine.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 25.0),

                new Reward(Slime.Companion.tier(2).getUpdatedItem(false).asQuantity(12), 15.0),
                new Reward(Stick.Companion.tier(2).getUpdatedItem(false).asQuantity(12), 15.0),
                new Reward(Vine.Companion.tier(2).getUpdatedItem(false).asQuantity(12), 15.0),

                new Reward(Slime.Companion.tier(3).getUpdatedItem(false).asQuantity(8), 15.0),
                new Reward(Stick.Companion.tier(3).getUpdatedItem(false).asQuantity(8), 15.0),
                new Reward(Vine.Companion.tier(3).getUpdatedItem(false).asQuantity(8), 15.0),

                new Reward(new Sugar(100).getUpdatedItem(false).asQuantity(4), 50.0),
                new Reward(new HillyWoodsDungeonKey(0).getUpdatedItem(false).asQuantity(3), 30.0)
        });
    }
}