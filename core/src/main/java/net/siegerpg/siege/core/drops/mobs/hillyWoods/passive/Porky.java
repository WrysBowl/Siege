package net.siegerpg.siege.core.drops.mobs.hillyWoods.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Porkchop;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;

public class Porky extends MobDropTable {

	public Porky() {

		super("Porky", 6, 9, 8, 11, new Reward[] {
				new Reward(new Leather()
						           .getUpdatedItem(false), 21.0),
				new Reward(new Leather()
						           .getUpdatedItem(false), 1.0),
				new Reward(new Bone()
						           .getUpdatedItem(false)
						           .asQuantity(2), 70.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 7.0),

				new Reward(new Porkchop().getUpdatedItem(false), 60.0),
				new Reward(new Porkchop().getUpdatedItem(false), 1.5),
				});
	}

}