package net.siegerpg.siege.core.drops.mobs.twilight.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;


public class Warrior_Dwarf extends MobDropTable {

	public Warrior_Dwarf() {

		super("Warrior_Dwarf", 60, 70, 50, 60, new Reward[] {
				new Reward(Bone.Companion
						           .tier(1)
						           .getUpdatedItem(false)
						           .asQuantity(4), 50.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false), 25.0),

				new Reward(Leather.Companion
						           .tier(1)
						           .getUpdatedItem(false)
						           .asQuantity(8), 60.0),
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false), 15.0),

				new Reward(RefinedMetal.Companion
						           .tier(1)
						           .getUpdatedItem(false)
						           .asQuantity(3), 25.0),
				new Reward(RefinedMetal.Companion
						           .tier(2)
						           .getUpdatedItem(false), 5.0),
				new Reward(MetalScrap.Companion
						           .tier(1)
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),
				new Reward(MetalScrap.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(2), 5.0),

				});
	}

}