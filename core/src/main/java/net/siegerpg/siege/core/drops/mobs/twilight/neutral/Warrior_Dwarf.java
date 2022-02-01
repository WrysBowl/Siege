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
				new Reward(new Bone()
						           .getUpdatedItem(false)
						           .asQuantity(4), 50.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 25.0),

				new Reward(new Leather()
						           .getUpdatedItem(false)
						           .asQuantity(8), 60.0),
				new Reward(new Leather()
						           .getUpdatedItem(false), 15.0),

				new Reward(new RefinedMetal()
						           .getUpdatedItem(false)
						           .asQuantity(3), 25.0),
				new Reward(new RefinedMetal()
						           .getUpdatedItem(false), 1.5),
				new Reward(new MetalScrap()
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),
				new Reward(new MetalScrap()
						           .getUpdatedItem(false)
						           .asQuantity(2), 1.5),

				});
	}

}