package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyWing;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.FlawedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;


public class Nightmare extends MobDropTable {

	public Nightmare() {

		super("Nightmare", 50, 60, 50, 60, new Reward[] {
				new Reward(new FairyDust().getUpdatedItem(false), 30.0),
				new Reward(new FairyDust().getUpdatedItem(false), 10.0),
				new Reward(new CorruptCrystal()
						           .getUpdatedItem(false), 25.0),
				new Reward(new CorruptCrystal()
						           .getUpdatedItem(false), 5.0),
				new Reward(new FairyWing().getUpdatedItem(false), 25.0),
				new Reward(new FairyWing().getUpdatedItem(false), 5.0),

				new Reward(new FlawedHealthGem(0).getUpdatedItem(false), 1.0),
				new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 0.5),
				});
	}

}
