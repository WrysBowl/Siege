package net.siegerpg.siege.core.drops.mobs.twilight.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.IceShard;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;


public class Polar_Bear extends MobDropTable {

	public Polar_Bear() {

		super("Polar_Bear", 100, 120, 150, 160, new Reward[] {
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

				new Reward(new IceShard()
						           .getUpdatedItem(false)
						           .asQuantity(3), 25.0),
				new Reward(new IceShard()
						           .getUpdatedItem(false), 1.5),
				new Reward(new Drumstick()
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),
				new Reward(new Drumstick()
						           .getUpdatedItem(false)
						           .asQuantity(4), 10.0)
		});
	}

}