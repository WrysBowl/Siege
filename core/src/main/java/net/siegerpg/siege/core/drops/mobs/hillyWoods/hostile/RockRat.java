package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.JaggedTunic;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.RawToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.PebbleShooter;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.crossbows.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.pebbleShooters.*;
import net.siegerpg.siege.core.items.implemented.weapons.wands.PebbleWand;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class RockRat extends MobDropTable {

	public RockRat() {

		super("RockRat", 3, 5, 2, 4, new Reward[] {
				new Reward(new Pebble()
						           .getUpdatedItem(false), 100.0),
				new Reward(new Pebble()
						           .getUpdatedItem(false), 10.0),
				new Reward(new JaggedTunic(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new PebbleShooter(Utils.randRarity()).getUpdatedItem(false), 0.30),
				new Reward(new ToughPebbleShooter(Utils.randRarity()).getUpdatedItem(false), 0.15),
				new Reward(new LuckyPebbleShooter(Utils.randRarity()).getUpdatedItem(false), 0.15),
				new Reward(new StrongPebbleShooter(Utils.randRarity()).getUpdatedItem(false), 0.15),
				new Reward(new HealingPebbleShooter(Utils.randRarity()).getUpdatedItem(false), 0.15),
				new Reward(new HealthyPebbleShooter(Utils.randRarity()).getUpdatedItem(false), 0.15),
				new Reward(new PebbleWand(Utils.randRarity()).getUpdatedItem(false), 2.5),

				new Reward(new MobKey(0).getUpdatedItem(false), 0.15),

				});
	}

}
