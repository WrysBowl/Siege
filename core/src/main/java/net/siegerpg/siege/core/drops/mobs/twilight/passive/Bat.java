package net.siegerpg.siege.core.drops.mobs.twilight.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyWing;


public class Bat extends MobDropTable {

	public Bat() {

		super("Bat", 10, 20, 10, 20, new Reward[] {
				new Reward(FairyWing.Companion
						           .tier(1)
						           .getUpdatedItem(false), 50.0),
				new Reward(FairyWing.Companion
						           .tier(2)
						           .getUpdatedItem(false), 20.0),
				new Reward(new Drumstick(50)
						           .getUpdatedItem(false)
						           .asQuantity(4), 75.0),
				new Reward(new Drumstick(100).getUpdatedItem(false), 25.0)
		});
	}

}