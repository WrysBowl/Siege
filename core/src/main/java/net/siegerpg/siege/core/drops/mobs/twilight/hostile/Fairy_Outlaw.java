package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyWing;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;


public class Fairy_Outlaw extends MobDropTable {

	public Fairy_Outlaw() {

		super("Fairy_Outlaw", 30, 50, 40, 60, new Reward[] {
				new Reward(new FairyDust().getUpdatedItem(false), 25.0),
				new Reward(new FairyDust().getUpdatedItem(false), 1.5),
				new Reward(new FairyWing().getUpdatedItem(false), 50.0),
				new Reward(new FairyWing().getUpdatedItem(false), 10.0),
				new Reward(new Leather()
						           .getUpdatedItem(false), 25.0),

				new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 0.25),
				new Reward(new FlawedRegenerationGem(0).getUpdatedItem(false), 0.25),
				});
	}

}
