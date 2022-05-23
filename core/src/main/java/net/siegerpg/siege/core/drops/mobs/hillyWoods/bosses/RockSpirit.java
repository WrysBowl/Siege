package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.GrieferChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.JaggedTunic;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.LichKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.ArrowShooter;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.pebbleShooters.*;
import net.siegerpg.siege.core.items.implemented.weapons.wands.RockWand;
import net.siegerpg.siege.core.items.implemented.weapons.wands.rockWands.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class RockSpirit extends MobDropTable {

	public RockSpirit() {

		super("RockSpirit", 67, 70, 156, 159, new Reward[] {
				new Reward(new Pebble().getUpdatedItem(false).asQuantity(4), 100.0),
				new Reward(new Pebble().getUpdatedItem(false).asQuantity(8), 10.0),

				new Reward(new GrieferChestplate(Utils.randRarity()).getUpdatedItem(false), 4.0),
				new Reward(new GrieferChestplate(100).getUpdatedItem(false), 0.10),
				new Reward(new GrieferChestplate(80).getUpdatedItem(false), 0.50),

				new Reward(new JaggedTunic(Utils.randRarity()).getUpdatedItem(false), 4.0),
				new Reward(new JaggedTunic(100).getUpdatedItem(false), 0.10),
				new Reward(new JaggedTunic(80).getUpdatedItem(false), 0.50),

				new Reward(new ArrowShooter(Utils.randRarity()).getUpdatedItem(false), 4.0),
				new Reward(new LuckyArrowShooter(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new ToughArrowShooter(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new StrongArrowShooter(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new HealingArrowShooter(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new HealthyArrowShooter(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new ArrowShooter(100).getUpdatedItem(false), 0.10),
				new Reward(new ArrowShooter(80).getUpdatedItem(false), 0.20),
				new Reward(new LuckyArrowShooter(50).getUpdatedItem(false), 0.025),
				new Reward(new ToughArrowShooter(50).getUpdatedItem(false), 0.025),
				new Reward(new StrongArrowShooter(50).getUpdatedItem(false), 0.025),
				new Reward(new HealingArrowShooter(50).getUpdatedItem(false), 0.025),
				new Reward(new HealthyArrowShooter(50).getUpdatedItem(false), 0.025),

				new Reward(new RockWand(Utils.randRarity()).getUpdatedItem(false), 4.0),
				new Reward(new LuckyRockWand(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new ToughRockWand(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new StrongRockWand(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new HealingRockWand(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new HealthyRockWand(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new RockWand(100).getUpdatedItem(false), 0.10),
				new Reward(new RockWand(80).getUpdatedItem(false), 0.20),
				new Reward(new LuckyRockWand(50).getUpdatedItem(false), 0.025),
				new Reward(new ToughRockWand(50).getUpdatedItem(false), 0.025),
				new Reward(new StrongRockWand(50).getUpdatedItem(false), 0.025),
				new Reward(new HealingRockWand(50).getUpdatedItem(false), 0.025),
				new Reward(new HealthyRockWand(50).getUpdatedItem(false), 0.025),

				new Reward(new LichKey(0).getUpdatedItem(false), 10.0),
				new Reward(new MobKey(0).getUpdatedItem(false), 3.0),

				});
	}

}