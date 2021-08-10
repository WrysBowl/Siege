package net.siegerpg.siege.core.drops.mobs.twilight.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.IceShard;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;


public class Polar_Bear extends MobDropTable {
    public Polar_Bear() {
        super("Polar_Bear", 100, 120, 150, 160, new Reward[]{
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 50.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 25.0),

                new Reward(Leather.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 60.0),
                new Reward(Leather.Companion.tier(3).getUpdatedItem(false), 15.0),

                new Reward(IceShard.Companion.tier(1).getUpdatedItem(false).asQuantity(3), 25.0),
                new Reward(IceShard.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(new Drumstick(50).getUpdatedItem(false).asQuantity(8), 25.0),
                new Reward(new Drumstick(100).getUpdatedItem(false).asQuantity(4), 10.0)
        });
    }
}