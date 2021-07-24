package net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.HillyWoodsDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;

public class ChestMimic1 extends MobDropTable {
    public ChestMimic1() {
        super("ChestMimic", 150, 300, 150, 300, new Reward[]{
                new Reward(Pebble.Companion.tier(2).getUpdatedItem(false), 50.0),
                new Reward(Pebble.Companion.tier(3).getUpdatedItem(false), 25.0),
                new Reward(Magma.Companion.tier(2).getUpdatedItem(false), 50.0),
                new Reward(Magma.Companion.tier(3).getUpdatedItem(false), 25.0),
                new Reward(Stick.Companion.tier(2).getUpdatedItem(false), 50.0),
                new Reward(Stick.Companion.tier(3).getUpdatedItem(false), 25.0),
                new Reward(MetalScrap.Companion.tier(2).getUpdatedItem(false), 25.0),
                new Reward(RefinedMetal.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(new Sugar(100).getUpdatedItem(false), 50.0),
                new Reward(new HillyWoodsDungeonKey(0).getUpdatedItem(false), 10.0),

                new Reward(Pebble.Companion.tier(2).getUpdatedItem(false), 50.0),
                new Reward(Pebble.Companion.tier(3).getUpdatedItem(false), 25.0),
                new Reward(Magma.Companion.tier(2).getUpdatedItem(false), 50.0),
                new Reward(Magma.Companion.tier(3).getUpdatedItem(false), 25.0),
                new Reward(Stick.Companion.tier(2).getUpdatedItem(false), 50.0),
                new Reward(Stick.Companion.tier(3).getUpdatedItem(false), 25.0),
                new Reward(MetalScrap.Companion.tier(2).getUpdatedItem(false), 25.0),
                new Reward(RefinedMetal.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(new Sugar(100).getUpdatedItem(false), 50.0),
                new Reward(new HillyWoodsDungeonKey(0).getUpdatedItem(false), 10.0),

                new Reward(Pebble.Companion.tier(2).getUpdatedItem(false), 50.0),
                new Reward(Pebble.Companion.tier(3).getUpdatedItem(false), 25.0),
                new Reward(Magma.Companion.tier(2).getUpdatedItem(false), 50.0),
                new Reward(Magma.Companion.tier(3).getUpdatedItem(false), 25.0),
                new Reward(Stick.Companion.tier(2).getUpdatedItem(false), 50.0),
                new Reward(Stick.Companion.tier(3).getUpdatedItem(false), 25.0),
                new Reward(MetalScrap.Companion.tier(2).getUpdatedItem(false), 25.0),
                new Reward(RefinedMetal.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(new Sugar(100).getUpdatedItem(false), 50.0),
                new Reward(new HillyWoodsDungeonKey(0).getUpdatedItem(false), 10.0)
        });
    }
}