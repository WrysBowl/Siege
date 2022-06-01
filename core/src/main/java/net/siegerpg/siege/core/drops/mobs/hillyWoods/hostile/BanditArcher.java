package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.BroodmotherKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.crossbows.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class BanditArcher extends MobDropTable {

	public BanditArcher() {

		super("BanditArcher", 30, 34, 220, 230, new Reward[] {
				new Reward(new Leather()
						           .getUpdatedItem(false), 50.0),
				new Reward(new Leather()
						           .getUpdatedItem(false), 1.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 50.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 1.0),
				new Reward(new MetalScrap()
						           .getUpdatedItem(false), 21.0),

				new Reward(new Crossbow(100).getUpdatedItem(false), 0.10),
				new Reward(new Crossbow(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new ToughCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new LuckyCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new MobKey().getUpdatedItem(false), 1.0),
				new Reward(new BroodmotherKey().getUpdatedItem(false), 0.10),

				});
	}

}
