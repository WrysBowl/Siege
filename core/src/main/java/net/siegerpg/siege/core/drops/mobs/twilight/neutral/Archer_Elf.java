package net.siegerpg.siege.core.drops.mobs.twilight.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.SteelString;


public class Archer_Elf extends MobDropTable {

	public Archer_Elf() {

		super("Archer_Elf", 40, 50, 50, 60, new Reward[] {
				new Reward(Bone.Companion
						           .tier(1)
						           .getUpdatedItem(false), 100.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false), 25.0),
				new Reward(Bone.Companion
						           .tier(3)
						           .getUpdatedItem(false), 5.0),

				new Reward(Leather.Companion
						           .tier(1)
						           .getUpdatedItem(false), 60.0),
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false), 12.0),
				new Reward(Leather.Companion
						           .tier(3)
						           .getUpdatedItem(false), 2.0),

				new Reward(SteelString.Companion
						           .tier(1)
						           .getUpdatedItem(false), 25.0),
				new Reward(SteelString.Companion
						           .tier(2)
						           .getUpdatedItem(false), 5.0),
				new Reward(RefinedMetal.Companion
						           .tier(1)
						           .getUpdatedItem(false), 25.0),
				new Reward(RefinedMetal.Companion
						           .tier(2)
						           .getUpdatedItem(false), 5.0),

				});
	}

}