package net.siegerpg.siege.core.drops.mobs.twilight.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.PristineHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.PolishedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.LuminousBow;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Unicorn extends MobDropTable {

	public Unicorn() {

		super("Unicorn", 400, 600, 900, 1000, new Reward[] {
				new Reward(new LuminousBow(Utils.randRarity()).getUpdatedItem(false), 25.0),
				new Reward(new Bone()
						           .getUpdatedItem(false)
						           .asQuantity(16), 50.0),
				new Reward(new Bone()
						           .getUpdatedItem(false)
						           .asQuantity(4), 50.0),
				new Reward(new Leather()
						           .getUpdatedItem(false)
						           .asQuantity(16), 50.0),
				new Reward(new GoldenCarrot()
						           .getUpdatedItem(false)
						           .asQuantity(4), 100.0),
				new Reward(new PristineHealthGem(0).getUpdatedItem(false), 20.0),
				new Reward(new PolishedRegenerationGem(0).getUpdatedItem(false), 20.0),
				});
	}

}