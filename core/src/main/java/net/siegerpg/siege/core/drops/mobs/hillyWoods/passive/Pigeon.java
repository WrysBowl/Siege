package net.siegerpg.siege.core.drops.mobs.hillyWoods.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather;

public class Pigeon extends MobDropTable {

	public Pigeon() {

		super("Pigeon", 2, 5, 3, 6, new Reward[] {
				new Reward(new Feather()
						           .getUpdatedItem(false), 60.0),
				new Reward(new Feather()
						           .getUpdatedItem(false), 1.5),
				new Reward(new Bone()
						           .getUpdatedItem(false), 10.0),
				new Reward(new Drumstick().getUpdatedItem(false), 50.0),
				});
	}

}