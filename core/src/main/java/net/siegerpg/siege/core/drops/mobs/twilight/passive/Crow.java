package net.siegerpg.siege.core.drops.mobs.twilight.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather;


public class Crow extends MobDropTable {

	public Crow() {

		super("Crow", 20, 30, 20, 30, new Reward[] {
				new Reward(new Feather()
						           .getUpdatedItem(false), 75.0),
				new Reward(new Feather()
						           .getUpdatedItem(false), 25.0),
				new Reward(new Drumstick()
						           .getUpdatedItem(false)
						           .asQuantity(4), 75.0),
				new Reward(new Drumstick().getUpdatedItem(false), 25.0)
		});
	}

}