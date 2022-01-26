package net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar;

public class ChestMimic4 extends MobDropTable {

	public ChestMimic4() {

		super("ChestMimic4", 150, 300, 150, 300, new Reward[] {

				new Reward(new Sugar()
						           .getUpdatedItem(false)
						           .asQuantity(12), 50.0),
				new Reward(new Sugar()
						           .getUpdatedItem(false)
						           .asQuantity(12), 50.0),
				});
	}

}