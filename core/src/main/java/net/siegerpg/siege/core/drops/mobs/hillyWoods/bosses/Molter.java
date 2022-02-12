package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

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
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.MagmaSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma;
import net.siegerpg.siege.core.items.implemented.weapons.wands.MatchStick;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Molter extends MobDropTable {

	public Molter() {

		super("Molter", 26, 29, 56, 60, new Reward[] {
				new Reward(new Magma().getUpdatedItem(false), 100.0),
				new Reward(new Magma().getUpdatedItem(false).asQuantity(4), 10.0),

				new Reward(new MagmaHelmet(80).getUpdatedItem(false), 0.25),
				new Reward(new MagmaChestplate(80).getUpdatedItem(false), 0.25),
				new Reward(new MagmaLeggings(80).getUpdatedItem(false), 0.25),
				new Reward(new MagmaBoots(80).getUpdatedItem(false), 0.25),

				new Reward(new ToughMagmaHelmet(50).getUpdatedItem(false), 0.025),
				new Reward(new ToughMagmaChestplate(50).getUpdatedItem(false), 0.025),
				new Reward(new ToughMagmaLeggings(50).getUpdatedItem(false), 0.025),
				new Reward(new ToughMagmaBoots(50).getUpdatedItem(false), 0.025),

				new Reward(new HealingMagmaHelmet(50).getUpdatedItem(false), 0.025),
				new Reward(new HealingMagmaChestplate(50).getUpdatedItem(false), 0.025),
				new Reward(new HealingMagmaLeggings(50).getUpdatedItem(false), 0.025),
				new Reward(new HealingMagmaBoots(50).getUpdatedItem(false), 0.025),

				new Reward(new HealthyMagmaHelmet(50).getUpdatedItem(false), 0.025),
				new Reward(new HealthyMagmaChestplate(50).getUpdatedItem(false), 0.025),
				new Reward(new HealthyMagmaLeggings(50).getUpdatedItem(false), 0.025),
				new Reward(new HealthyMagmaBoots(50).getUpdatedItem(false), 0.025),

				new Reward(new StrongMagmaHelmet(50).getUpdatedItem(false), 0.025),
				new Reward(new StrongMagmaChestplate(50).getUpdatedItem(false), 0.025),
				new Reward(new StrongMagmaLeggings(50).getUpdatedItem(false), 0.025),
				new Reward(new StrongMagmaBoots(50).getUpdatedItem(false), 0.025),

				new Reward(new LuckyMagmaHelmet(50).getUpdatedItem(false), 0.025),
				new Reward(new LuckyMagmaChestplate(50).getUpdatedItem(false), 0.025),
				new Reward(new LuckyMagmaLeggings(50).getUpdatedItem(false), 0.025),
				new Reward(new LuckyMagmaBoots(50).getUpdatedItem(false), 0.025),

				new Reward(new MagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.20),
				new Reward(new MagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.20),
				new Reward(new MagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.20),
				new Reward(new MagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.20),

				new Reward(new ToughMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new ToughMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new ToughMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new ToughMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.025),

				new Reward(new HealingMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new HealingMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new HealingMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new HealingMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.025),

				new Reward(new HealthyMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new HealthyMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new HealthyMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new HealthyMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.025),

				new Reward(new StrongMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new StrongMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new StrongMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new StrongMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.025),

				new Reward(new LuckyMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new LuckyMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new LuckyMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new LuckyMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.025),

				new Reward(new MatchStick(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new MagmaSpiritKey().getUpdatedItem(false), 5.0),
				new Reward(new MobKey(0).getUpdatedItem(false), 2.0),

				});
	}

}
