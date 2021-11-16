package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Wool;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.PolishedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.PolishedRegenerationGem;


public class Digger_Overseer extends MobDropTable {
	public Digger_Overseer () {
		super("Digger_Overseer", 120, 140, 140, 160, new Reward[] {
				new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 30.0),
				new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 10.0),
				new Reward(Wool.Companion.tier(1).getUpdatedItem(false).asQuantity(3), 50.0),
				new Reward(Wool.Companion.tier(2).getUpdatedItem(false), 15.0),
				new Reward(Leather.Companion.tier(1).getUpdatedItem(false).asQuantity(4), 30.0),
				new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 10.0),

				new Reward(new PolishedRegenerationGem(0).getUpdatedItem(false), 0.5),
				new Reward(new PolishedHealthGem(0).getUpdatedItem(false), 1.0),
		});
	}
}
