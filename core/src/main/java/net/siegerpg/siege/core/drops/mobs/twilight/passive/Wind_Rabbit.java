package net.siegerpg.siege.core.drops.mobs.twilight.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Pelt;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.RabbitFoot;


public class Wind_Rabbit extends MobDropTable {

	public Wind_Rabbit() {

		super("Wind_Rabbit", 40, 50, 35, 45, new Reward[] {
				new Reward(RabbitFoot.Companion
						           .tier(1)
						           .getUpdatedItem(false), 100.0),
				new Reward(RabbitFoot.Companion
						           .tier(2)
						           .getUpdatedItem(false), 25.0),
				new Reward(Pelt.Companion
						           .tier(1)
						           .getUpdatedItem(false), 50.0),
				new Reward(Pelt.Companion
						           .tier(2)
						           .getUpdatedItem(false), 10.0),
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(3), 25.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(6), 25.0),
				new Reward(new Drumstick().getUpdatedItem(false), 25.0)
		});
	}

}