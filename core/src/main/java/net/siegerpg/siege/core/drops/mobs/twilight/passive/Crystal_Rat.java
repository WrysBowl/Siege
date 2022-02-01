package net.siegerpg.siege.core.drops.mobs.twilight.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;


public class Crystal_Rat extends MobDropTable {

	public Crystal_Rat() {

		super("Crystal_Rat", 210, 230, 230, 240, new Reward[] {
				new Reward(new Crystal()
						           .getUpdatedItem(false)
						           .asQuantity(4), 75.0),
				new Reward(new Crystal()
						           .getUpdatedItem(false)
						           .asQuantity(2), 25.0),
				new Reward(new Crystal()
						           .getUpdatedItem(false), 1.5),
				new Reward(new FairyDust()
						           .getUpdatedItem(false)
						           .asQuantity(4), 35.0),
				new Reward(new FairyDust()
						           .getUpdatedItem(false), 1.5),
				new Reward(new Drumstick().getUpdatedItem(false), 25.0)

		});
	}

}