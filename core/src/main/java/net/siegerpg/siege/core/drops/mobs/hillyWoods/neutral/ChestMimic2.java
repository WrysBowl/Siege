package net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma;

public class ChestMimic2 extends MobDropTable {

	public ChestMimic2() {

		super("ChestMimic2", 850, 900, 150, 200, new Reward[] {
				new Reward(new Magma()
						           .getUpdatedItem(false)
						           .asQuantity(8), 22.5),
				new Reward(new Bone()
						           .getUpdatedItem(false)
						           .asQuantity(8), 22.5),
				new Reward(new Pebble()
						           .getUpdatedItem(false)
						           .asQuantity(8), 22.5),

				new Reward(new Magma()
						           .getUpdatedItem(false)
						           .asQuantity(12), 12.5),
				new Reward(new Bone()
						           .getUpdatedItem(false)
						           .asQuantity(12), 12.5),
				new Reward(new Pebble()
						           .getUpdatedItem(false)
						           .asQuantity(12), 12.5),

				new Reward(new Magma()
						           .getUpdatedItem(false)
						           .asQuantity(8), 12.5),
				new Reward(new Bone()
						           .getUpdatedItem(false)
						           .asQuantity(8), 12.5),
				new Reward(new Pebble()
						           .getUpdatedItem(false)
						           .asQuantity(8), 12.5),

				new Reward(new Sugar()
						           .getUpdatedItem(false)
						           .asQuantity(4), 50.0),
				});
	}

}