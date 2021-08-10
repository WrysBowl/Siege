package net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.fishing.baits.BaitCore;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;

public class ChestMimic2 extends MobDropTable {
    public ChestMimic2() {
        super("ChestMimic2", 150, 300, 150, 300, new Reward[]{
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false).asQuantity(8), 75.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 25.0),
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false).asQuantity(8), 75.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 25.0),
                new Reward(new Drumstick(100).getUpdatedItem(false).asQuantity(4), 25.0),
                new Reward(new Drumstick(50).getUpdatedItem(false).asQuantity(8), 50.0),
                new Reward(BaitCore.getBait("BearacudaBait").getBaitItemStack().asQuantity(4), 15.0),
                new Reward(BaitCore.getBait("BigBlueTunaBait").getBaitItemStack().asQuantity(5), 25.0),
                new Reward(BaitCore.getBait("FlashySharkBait").getBaitItemStack().asQuantity(3), 10.0)


        });
    }
}