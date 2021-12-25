package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.SusStew;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.NecromancerKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.CrackedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.RawLuckGem;
import net.siegerpg.siege.core.miscellaneous.Utils;


public class Goblin extends MobDropTable {

	public Goblin() {

		super("Goblin", 30, 33, 30, 33, new Reward[] {
				new Reward(Leather.Companion
						           .tier(1)
						           .getUpdatedItem(false), 25.0),
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false), 5.0),
				new Reward(Bone.Companion
						           .tier(1)
						           .getUpdatedItem(false), 100.0),

				new Reward(new SusStew(Utils.randRarity()).getUpdatedItem(false), 5.0),
				new Reward(new CrackedLuckGem(0).getUpdatedItem(false), 1.0),
				new Reward(new RawLuckGem(0).getUpdatedItem(false), 2.0),

				new Reward(new MobKey(0).getUpdatedItem(false), 5.0),
				new Reward(new NecromancerKey(0).getUpdatedItem(false), 2.0),

				});
	}

}
