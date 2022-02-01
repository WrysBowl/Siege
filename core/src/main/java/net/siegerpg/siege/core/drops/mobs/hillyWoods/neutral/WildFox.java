package net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;

public class WildFox extends MobDropTable {

	public WildFox() {

		super("WildFox", 14, 17, 20, 23, new Reward[] {
				new Reward(new Bone()
						           .getUpdatedItem(false), 21.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 1.0),
				new Reward(new Leather()
						           .getUpdatedItem(false), 50.0),
				new Reward(new Leather()
						           .getUpdatedItem(false), 1.0),
				new Reward(new Drumstick().getUpdatedItem(false), 1.0),
				new Reward(new Drumstick().getUpdatedItem(false), 21.0),
				});
	}

}