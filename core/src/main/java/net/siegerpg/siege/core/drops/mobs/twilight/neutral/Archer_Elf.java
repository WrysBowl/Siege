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
				new Reward(new Bone()
						           .getUpdatedItem(false), 100.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 25.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 1.5),

				new Reward(new Leather()
						           .getUpdatedItem(false), 60.0),
				new Reward(new Leather()
						           .getUpdatedItem(false), 5.0),
				new Reward(new Leather()
						           .getUpdatedItem(false), 0.75),

				new Reward(new SteelString()
						           .getUpdatedItem(false), 25.0),
				new Reward(new SteelString()
						           .getUpdatedItem(false), 1.5),
				new Reward(new RefinedMetal()
						           .getUpdatedItem(false), 25.0),
				new Reward(new RefinedMetal()
						           .getUpdatedItem(false), 1.5),

				});
	}

}