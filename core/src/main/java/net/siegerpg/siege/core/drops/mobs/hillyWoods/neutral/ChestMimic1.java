package net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime;

public class ChestMimic1 extends MobDropTable {

	public ChestMimic1() {

		super("ChestMimic1", 150, 200, 250, 300, new Reward[] {
				new Reward(new Slime()
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),
				new Reward(new Stick()
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),
				new Reward(new Vine()
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),

				new Reward(new Slime()
						           .getUpdatedItem(false)
						           .asQuantity(12), 15.0),
				new Reward(new Stick()
						           .getUpdatedItem(false)
						           .asQuantity(12), 15.0),
				new Reward(new Vine()
						           .getUpdatedItem(false)
						           .asQuantity(12), 15.0),

				new Reward(new Slime()
						           .getUpdatedItem(false)
						           .asQuantity(8), 15.0),
				new Reward(new Stick()
						           .getUpdatedItem(false)
						           .asQuantity(8), 15.0),
				new Reward(new Vine()
						           .getUpdatedItem(false)
						           .asQuantity(8), 15.0),

				new Reward(new Sugar()
						           .getUpdatedItem(false)
						           .asQuantity(4), 50.0),
				});
	}

}