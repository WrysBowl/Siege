package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;


public class Stone_Monster extends MobDropTable {

	public Stone_Monster() {

		super("Stone_Monster", 35, 45, 45, 55, new Reward[] {
				new Reward(new Pebble()
						           .getUpdatedItem(false), 25.0),
				new Reward(new Pebble()
						           .getUpdatedItem(false), 5.0),
				new Reward(new FairyDust().getUpdatedItem(false), 50.0),
				new Reward(new FairyDust().getUpdatedItem(false), 10.0),
				new Reward(new PlantMatter().getUpdatedItem(false), 50.0),

				new Reward(new FlawedStrengthGem(0).getUpdatedItem(false), 1.0),
				new Reward(new SimpleToughGem(0).getUpdatedItem(false), 0.5),
				});
	}

}
