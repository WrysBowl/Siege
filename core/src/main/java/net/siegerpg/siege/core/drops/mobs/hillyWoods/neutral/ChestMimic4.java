package net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed;

public class ChestMimic4 extends MobDropTable {

	public ChestMimic4() {

		super("ChestMimic4", 150, 300, 150, 300, new Reward[] {
				new Reward(PlantMatter.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),
				new Reward(Seed.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(8), 25.0),

				new Reward(PlantMatter.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(12), 15.0),
				new Reward(Seed.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(12), 15.0),

				new Reward(PlantMatter.Companion
						           .tier(3)
						           .getUpdatedItem(false)
						           .asQuantity(8), 15.0),
				new Reward(Seed.Companion
						           .tier(3)
						           .getUpdatedItem(false)
						           .asQuantity(8), 15.0),

				new Reward(new Sugar(100)
						           .getUpdatedItem(false)
						           .asQuantity(4), 50.0),
				new Reward(new Sugar(100)
						           .getUpdatedItem(false)
						           .asQuantity(4), 50.0),
				});
	}

}