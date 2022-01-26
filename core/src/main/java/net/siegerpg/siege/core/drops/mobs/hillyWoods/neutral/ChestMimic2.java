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
				new Reward(Magma.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),
				new Reward(Pebble.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),

				new Reward(Magma.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(12), 15.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(12), 15.0),
				new Reward(Pebble.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(12), 15.0),

				new Reward(Magma.Companion
						           .tier(3)
						           .getUpdatedItem(false)
						           .asQuantity(8), 15.0),
				new Reward(Bone.Companion
						           .tier(3)
						           .getUpdatedItem(false)
						           .asQuantity(8), 15.0),
				new Reward(Pebble.Companion
						           .tier(3)
						           .getUpdatedItem(false)
						           .asQuantity(8), 15.0),

				new Reward(new Sugar()
						           .getUpdatedItem(false)
						           .asQuantity(4), 50.0),
				});
	}

}