package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.MagmaBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.magmaBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.MagmaChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.magmaChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.MagmaHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.magmaHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.MagmaLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.magmaLeggings.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.RawStrengthGem;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class FlamingGoo extends MobDropTable {

	public FlamingGoo() {

		super("FlamingGoo", 3, 6, 5, 7, new Reward[] {
				new Reward(new Magma()
						           .getUpdatedItem(false), 50.0),
				new Reward(new Magma()
						           .getUpdatedItem(false), 5.0),

				new Reward(new MagmaHelmet(30).getUpdatedItem(false), 1.0),
				new Reward(new MagmaChestplate(30).getUpdatedItem(false), 1.0),
				new Reward(new MagmaLeggings(30).getUpdatedItem(false), 1.0),
				new Reward(new MagmaBoots(30).getUpdatedItem(false), 1.0),

				new Reward(new MagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new MagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new MagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new MagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.5),

				new Reward(new ToughMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new ToughMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new ToughMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new ToughMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.05),

				new Reward(new HealingMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealingMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealingMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealingMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.05),

				new Reward(new HealthyMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealthyMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealthyMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealthyMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.05),

				new Reward(new StrongMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new StrongMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new StrongMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new StrongMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.05),

				new Reward(new LuckyMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new LuckyMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new LuckyMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new LuckyMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.05),

				new Reward(new MobKey(0).getUpdatedItem(false), 1.0),

				});
	}

}
