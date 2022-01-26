package net.siegerpg.siege.core.drops.mobs.twilight.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Pelt;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.RabbitFoot;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.SteelString;


public class Twilight_Cat extends MobDropTable {

	public Twilight_Cat() {

		super("Twilight_Cat", 30, 40, 30, 40, new Reward[] {
				new Reward(new RabbitFoot()
						           .getUpdatedItem(false), 25.0),
				new Reward(new SteelString()
						           .getUpdatedItem(false), 25.0),
				new Reward(new Pelt()
						           .getUpdatedItem(false), 50.0),
				new Reward(new Pelt()
						           .getUpdatedItem(false), 10.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 25.0),
				new Reward(new Drumstick().getUpdatedItem(false), 25.0)

		});
	}

}