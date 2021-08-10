package net.siegerpg.siege.core.drops.mobs.twilight.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;


public class Warrior_Elf extends MobDropTable {
    public Warrior_Elf() {
        super("Warrior_Elf", 50, 60, 40, 50, new Reward[]{
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 100.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 25.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 5.0),

                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 60.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 12.0),
                new Reward(Leather.Companion.tier(3).getUpdatedItem(false), 2.0),

                new Reward(RefinedMetal.Companion.tier(1).getUpdatedItem(false), 75.0),
                new Reward(RefinedMetal.Companion.tier(2).getUpdatedItem(false), 25.0)

        });
    }
}