package net.siegerpg.siege.core.drops.mobs.hillyWoods.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Beef;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;

public class MooMoo extends MobDropTable {

	public MooMoo() {

		super("MooMoo", 10, 13, 8, 11, new Reward[] {
				new Reward(Bone.Companion
						           .tier(1)
						           .getUpdatedItem(false)
						           .asQuantity(3), 100.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false), 10.0),

				new Reward(Leather.Companion
						           .tier(1)
						           .getUpdatedItem(false), 80.0),
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false), 8.0),
				new Reward(new Beef().getUpdatedItem(false), 100.0),
				});
	}

}