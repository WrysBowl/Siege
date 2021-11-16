package net.siegerpg.siege.core.drops.mobs.hillyWoods.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;

public class Sushi extends MobDropTable {
	public Sushi () {
		super("Sushi", 1, 3, 1, 3, new Reward[] {
				new Reward(new Drumstick(0).getUpdatedItem(false), 20.0),
		});
	}
}