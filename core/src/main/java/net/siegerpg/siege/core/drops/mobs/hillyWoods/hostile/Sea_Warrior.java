package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.SusStew;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Chain;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;

public class Sea_Warrior extends MobDropTable {

	public Sea_Warrior() {

		super("Sea_Warrior", 47, 50, 66, 69, new Reward[] {
				new Reward(new MetalScrap()
						           .getUpdatedItem(false)
						           .asQuantity(2), 100.0),
				new Reward(new MetalScrap()
						           .getUpdatedItem(false)
						           .asQuantity(1), 10.0),
				new Reward(new Chain()
						           .getUpdatedItem(false)
						           .asQuantity(2), 100.0),
				new Reward(new Chain()
						           .getUpdatedItem(false)
						           .asQuantity(1), 10.0),

				new Reward(new SusStew().getUpdatedItem(false), 0.10),
				new Reward(new MobKey(0).getUpdatedItem(false), 1.0),

				});
	}

}