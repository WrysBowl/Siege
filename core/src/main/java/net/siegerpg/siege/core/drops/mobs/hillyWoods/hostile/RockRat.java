package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.JaggedTunic;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.RawToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.PebbleShooter;
import net.siegerpg.siege.core.items.implemented.weapons.wands.PebbleWand;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class RockRat extends MobDropTable {

	public RockRat() {

		super("RockRat", 3, 5, 2, 4, new Reward[] {
				new Reward(Pebble.Companion
						           .tier(1)
						           .getUpdatedItem(false), 100.0),
				new Reward(Pebble.Companion
						           .tier(2)
						           .getUpdatedItem(false), 10.0),
				new Reward(new JaggedTunic(Utils.randRarity()).getUpdatedItem(false), 5.0),
				new Reward(new PebbleShooter(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new PebbleWand(Utils.randRarity()).getUpdatedItem(false), 5.0),
				new Reward(new RawToughGem(0).getUpdatedItem(false), 1.0),
				});
	}

}
