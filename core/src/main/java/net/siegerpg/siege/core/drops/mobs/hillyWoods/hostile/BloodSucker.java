package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.SusStew;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.DavyJonesKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.crossbows.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class BloodSucker extends MobDropTable {

	public BloodSucker() {

		super("BloodSucker", 37, 40, 26, 29, new Reward[] {
				new Reward(new Vine()
						           .getUpdatedItem(false)
						           .asQuantity(3), 100.0),
				new Reward(new Vine()
						           .getUpdatedItem(false)
						           .asQuantity(2), 10.0),

				new Reward(new Crossbow(50).getUpdatedItem(false), 0.10),
				new Reward(new LuckyCrossbow(50).getUpdatedItem(false), 0.10),
				new Reward(new StrongCrossbow(50).getUpdatedItem(false), 0.10),
				new Reward(new HealingCrossbow(50).getUpdatedItem(false), 0.10),

				new Reward(new Crossbow(30).getUpdatedItem(false), 0.50),
				new Reward(new LuckyCrossbow(30).getUpdatedItem(false), 0.50),
				new Reward(new StrongCrossbow(30).getUpdatedItem(false), 0.50),
				new Reward(new HealingCrossbow(30).getUpdatedItem(false), 0.50),

				new Reward(new ToughCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new LuckyCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new SusStew().getUpdatedItem(false), 0.10),
				new Reward(new MobKey(0).getUpdatedItem(false), 2.5),
				new Reward(new DavyJonesKey(0).getUpdatedItem(false), 1.0),

				});
	}

}
