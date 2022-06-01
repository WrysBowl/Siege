package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.JaggedTunic;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.ArrowShooter;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.pebbleShooters.*;
import net.siegerpg.siege.core.items.implemented.weapons.wands.PebbleWand;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class RockRat extends MobDropTable {

	public RockRat() {

		super("RockRat", 3, 5, 8, 10, new Reward[] {
				new Reward(new Pebble()
						           .getUpdatedItem(false), 100.0),
				new Reward(new Pebble()
						           .getUpdatedItem(false), 10.0),
				new Reward(new JaggedTunic(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ArrowShooter(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new ToughArrowShooter(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new LuckyArrowShooter(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongArrowShooter(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingArrowShooter(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyArrowShooter(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new PebbleWand(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new MobKey().getUpdatedItem(false), 0.5),

				});
	}

}
