package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.SteelString;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PolishedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.PolishedRegenerationGem;


public class Greater_Spider extends MobDropTable {

	public Greater_Spider() {

		super("Greater_Spider", 100, 120, 200, 240, new Reward[] {
				new Reward(Bone.Companion
						           .tier(1)
						           .getUpdatedItem(false)
						           .asQuantity(8), 30.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false), 10.0),
				new Reward(SteelString.Companion
						           .tier(1)
						           .getUpdatedItem(false)
						           .asQuantity(8), 60.0),
				new Reward(SteelString.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(3), 15.0),

				new Reward(new PolishedRegenerationGem(0).getUpdatedItem(false), 0.5),
				new Reward(new PolishedLuckGem(0).getUpdatedItem(false), 1.0),
				});
	}

}
