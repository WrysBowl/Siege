package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.SparklingLeaves;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;


public class Leaf_Monster extends MobDropTable {

	public Leaf_Monster() {

		super("Leaf_Monster", 40, 50, 35, 45, new Reward[] {
				new Reward(new SparklingLeaves()
						           .getUpdatedItem(false), 25.0),
				new Reward(new SparklingLeaves()
						           .getUpdatedItem(false), 1.5),
				new Reward(new FairyDust().getUpdatedItem(false), 50.0),
				new Reward(new FairyDust().getUpdatedItem(false), 10.0),
				new Reward(new PlantMatter()
						           .getUpdatedItem(false), 50.0),

				new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 0.25),
				new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 0.10),
				});
	}

}
