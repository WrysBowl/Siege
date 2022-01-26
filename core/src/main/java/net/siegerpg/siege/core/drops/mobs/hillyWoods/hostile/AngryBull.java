package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.LeatherBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.hardenedLeatherBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.LeatherChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.hardenedLeatherChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.LeatherHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.hardenedLeatherHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.LeatherLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.hardenedLeatherLeggings.*;
import net.siegerpg.siege.core.items.implemented.misc.food.Beef;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.BullSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.FlawedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.DoubleBladedAxe;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.doubleBladedAxes.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class AngryBull extends MobDropTable {

	public AngryBull() {

		super("AngryBull", 17, 20, 26, 29, new Reward[] {
				new Reward(Leather.Companion
						           .tier(1)
						           .getUpdatedItem(false), 80.0),
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false), 8.0),
				new Reward(Bone.Companion
						           .tier(1)
						           .getUpdatedItem(false), 50.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false), 5.0),

				new Reward(new LeatherHelmet(50).getUpdatedItem(false), 1.5),
				new Reward(new LeatherChestplate(50).getUpdatedItem(false), 1.5),
				new Reward(new LeatherLeggings(50).getUpdatedItem(false), 1.5),
				new Reward(new LeatherBoots(50).getUpdatedItem(false), 1.5),

				new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new ToughHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new ToughHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new ToughHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new ToughHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.25),

				new Reward(new HealingHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealingHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealingHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealingHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.25),

				new Reward(new HealthyHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealthyHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealthyHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealthyHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.25),

				new Reward(new StrongHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new StrongHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new StrongHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new StrongHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.25),

				new Reward(new LuckyHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new LuckyHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new LuckyHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new LuckyHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.25),

				new Reward(new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new ToughDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new LuckyDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new StrongDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new HealingDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new HealthyDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.1),

				new Reward(new Beef().getUpdatedItem(false), 40.0),
				new Reward(new MobKey(0).getUpdatedItem(false), 1.5),
				new Reward(new BullSpiritKey(0).getUpdatedItem(false), 1.0),

				});
	}

}
