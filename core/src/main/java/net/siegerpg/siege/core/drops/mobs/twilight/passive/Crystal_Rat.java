package net.siegerpg.siege.core.drops.mobs.twilight.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;


public class Crystal_Rat extends MobDropTable {

	public Crystal_Rat() {

		super("Crystal_Rat", 210, 230, 230, 240, new Reward[] {
				new Reward(Crystal.Companion
						           .tier(1)
						           .getUpdatedItem(false)
						           .asQuantity(4), 75.0),
				new Reward(Crystal.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(2), 25.0),
				new Reward(Crystal.Companion
						           .tier(3)
						           .getUpdatedItem(false), 5.0),
				new Reward(FairyDust.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(4), 35.0),
				new Reward(FairyDust.Companion
						           .tier(3)
						           .getUpdatedItem(false), 5.0),
				new Reward(new Drumstick().getUpdatedItem(false), 25.0)

		});
	}

}