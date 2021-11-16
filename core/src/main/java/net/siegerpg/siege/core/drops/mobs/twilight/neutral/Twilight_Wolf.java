package net.siegerpg.siege.core.drops.mobs.twilight.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Pelt;


public class Twilight_Wolf extends MobDropTable {
	public Twilight_Wolf () {
		super("Twilight_Wolf", 30, 40, 30, 40, new Reward[] {
				new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 100.0),
				new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 25.0),
				new Reward(Pelt.Companion.tier(1).getUpdatedItem(false), 60.0),
				new Reward(Pelt.Companion.tier(2).getUpdatedItem(false), 12.0),
				new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 5.0)
		});
	}
}