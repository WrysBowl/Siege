package net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Wool;

public class ChestMimic3 extends MobDropTable {

	public ChestMimic3() {

		super("ChestMimic3", 350, 400, 250, 300, new Reward[] {
				new Reward(new Leather()
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),
				new Reward(new Wool()
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),
				new Reward(new Bone()
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),

				new Reward(new Leather()
						           .getUpdatedItem(false)
						           .asQuantity(12), 15.0),
				new Reward(new Wool()
						           .getUpdatedItem(false)
						           .asQuantity(12), 15.0),
				new Reward(new Bone()
						           .getUpdatedItem(false)
						           .asQuantity(12), 15.0),

				new Reward(new Leather()
						           .getUpdatedItem(false)
						           .asQuantity(8), 15.0),
				new Reward(new Wool()
						           .getUpdatedItem(false)
						           .asQuantity(8), 15.0),
				new Reward(new Bone()
						           .getUpdatedItem(false)
						           .asQuantity(8), 15.0),

				new Reward(new Sugar()
						           .getUpdatedItem(false)
						           .asQuantity(4), 50.0),
				});
	}

}