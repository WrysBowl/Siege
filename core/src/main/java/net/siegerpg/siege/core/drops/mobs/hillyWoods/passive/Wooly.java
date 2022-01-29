package net.siegerpg.siege.core.drops.mobs.hillyWoods.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Wool;

public class Wooly extends MobDropTable {

	public Wooly() {

		super("Wooly", 10, 13, 8, 11, new Reward[] {
				new Reward(new Wool()
						           .getUpdatedItem(false), 100.0),
				new Reward(new Wool()
						           .getUpdatedItem(false), 10.0),
				new Reward(new Wool()
						           .getUpdatedItem(false), 0.30),
				new Reward(new Bone()
						           .getUpdatedItem(false)
						           .asQuantity(2), 80.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 8.0),

				new Reward(new Drumstick().getUpdatedItem(false), 22.5),
				});
	}

}