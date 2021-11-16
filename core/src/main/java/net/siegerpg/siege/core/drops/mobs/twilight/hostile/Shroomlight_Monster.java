package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.ShroomPowder;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;


public class Shroomlight_Monster extends MobDropTable {
	public Shroomlight_Monster () {
		super("Shroomlight_Monster", 35, 45, 45, 55, new Reward[] {
				new Reward(ShroomPowder.Companion.tier(1).getUpdatedItem(false), 25.0),
				new Reward(ShroomPowder.Companion.tier(2).getUpdatedItem(false), 5.0),
				new Reward(FairyDust.Companion.tier(1).getUpdatedItem(false), 50.0),
				new Reward(FairyDust.Companion.tier(2).getUpdatedItem(false), 10.0),
				new Reward(PlantMatter.Companion.tier(2).getUpdatedItem(false), 50.0),

				new Reward(new FlawedToughGem(0).getUpdatedItem(false), 1.0),
				new Reward(new SimpleLuckGem(0).getUpdatedItem(false), 0.5),
		});
	}
}
