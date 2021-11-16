package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.JaggedTunic;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.PebbleShooter;
import net.siegerpg.siege.core.items.implemented.weapons.wands.PebbleWand;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class ScrapRat extends MobDropTable {

	public ScrapRat() {

		super("ScrapRat", 13, 15, 12, 14, new Reward[] {
				new Reward(Pebble.Companion
						           .tier(2)
						           .getUpdatedItem(false), 100.0),
				new Reward(Pebble.Companion
						           .tier(3)
						           .getUpdatedItem(false), 10.0),

				new Reward(new JaggedTunic(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new JaggedTunic(100).getUpdatedItem(false), 1.0),

				new Reward(new PebbleShooter(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new PebbleShooter(100).getUpdatedItem(false), 1.0),

				new Reward(new PebbleWand(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new PebbleWand(100).getUpdatedItem(false), 1.0),

				new Reward(new SimpleToughGem(0).getUpdatedItem(false), 1.0),
				});
	}

}
