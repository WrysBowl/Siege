package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyWing;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;


public class Dark_Fairy extends MobDropTable {

	public Dark_Fairy() {

		super("Dark_Fairy", 50, 60, 50, 60, new Reward[] {
				new Reward(new FairyDust().getUpdatedItem(false), 25.0),
				new Reward(new FairyDust().getUpdatedItem(false), 1.5),
				new Reward(new FairyWing().getUpdatedItem(false), 50.0),
				new Reward(new FairyWing().getUpdatedItem(false), 10.0),
				new Reward(new CorruptCrystal()
						           .getUpdatedItem(false), 25.0),

				new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 0.10),
				new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 0.10),
				});
	}

}
