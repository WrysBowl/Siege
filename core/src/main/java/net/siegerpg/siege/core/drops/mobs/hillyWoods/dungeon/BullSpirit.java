package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

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
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.CrackedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.FlawedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.CrackedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.CrackedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.CrackedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.CrackedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.DoubleBladedAxe;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.doubleBladedAxes.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class BullSpirit extends MobDropTable {

	public BullSpirit() {

		super("BullSpirit", 2500, 2700, 15000, 20000, new Reward[] {
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(8), 100.0),
				new Reward(Leather.Companion
						           .tier(3)
						           .getUpdatedItem(false)
						           .asQuantity(2), 25.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(8), 100.0),
				new Reward(Bone.Companion
						           .tier(3)
						           .getUpdatedItem(false)
						           .asQuantity(2), 25.0),

				new Reward(new LeatherHelmet(100).getUpdatedItem(false), 5.5),
				new Reward(new LeatherChestplate(100).getUpdatedItem(false), 5.5),
				new Reward(new LeatherLeggings(100).getUpdatedItem(false), 5.5),
				new Reward(new LeatherBoots(100).getUpdatedItem(false), 5.5),

				new Reward(new LeatherHelmet(80).getUpdatedItem(false), 25.5),
				new Reward(new LeatherChestplate(80).getUpdatedItem(false), 25.5),
				new Reward(new LeatherLeggings(80).getUpdatedItem(false), 25.5),
				new Reward(new LeatherBoots(80).getUpdatedItem(false), 25.5),

				new Reward(new ToughHardenedLeatherHelmet(50).getUpdatedItem(false), 1.0),
				new Reward(new ToughHardenedLeatherChestplate(50).getUpdatedItem(false), 1.0),
				new Reward(new ToughHardenedLeatherLeggings(50).getUpdatedItem(false), 1.0),
				new Reward(new ToughHardenedLeatherBoots(50).getUpdatedItem(false), 1.0),

				new Reward(new HealingHardenedLeatherHelmet(50).getUpdatedItem(false), 1.0),
				new Reward(new HealingHardenedLeatherChestplate(50).getUpdatedItem(false), 1.0),
				new Reward(new HealingHardenedLeatherLeggings(50).getUpdatedItem(false), 1.0),
				new Reward(new HealingHardenedLeatherBoots(50).getUpdatedItem(false), 1.0),

				new Reward(new HealthyHardenedLeatherHelmet(50).getUpdatedItem(false), 1.0),
				new Reward(new HealthyHardenedLeatherChestplate(50).getUpdatedItem(false), 1.0),
				new Reward(new HealthyHardenedLeatherLeggings(50).getUpdatedItem(false), 1.0),
				new Reward(new HealthyHardenedLeatherBoots(50).getUpdatedItem(false), 1.0),

				new Reward(new StrongHardenedLeatherHelmet(50).getUpdatedItem(false), 1.0),
				new Reward(new StrongHardenedLeatherChestplate(50).getUpdatedItem(false), 1.0),
				new Reward(new StrongHardenedLeatherLeggings(50).getUpdatedItem(false), 1.0),
				new Reward(new StrongHardenedLeatherBoots(50).getUpdatedItem(false), 1.0),

				new Reward(new LuckyHardenedLeatherHelmet(50).getUpdatedItem(false), 1.0),
				new Reward(new LuckyHardenedLeatherChestplate(50).getUpdatedItem(false), 1.0),
				new Reward(new LuckyHardenedLeatherLeggings(50).getUpdatedItem(false), 1.0),
				new Reward(new LuckyHardenedLeatherBoots(50).getUpdatedItem(false), 1.0),

				new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 20.0),

				new Reward(new ToughHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ToughHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ToughHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ToughHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new HealingHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealingHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealingHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealingHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new HealthyHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealthyHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealthyHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealthyHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new StrongHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new StrongHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new StrongHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new StrongHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new LuckyHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new LuckyHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new LuckyHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new LuckyHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new DoubleBladedAxe(100).getUpdatedItem(false), 7.5),
				new Reward(new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 25.5),
				new Reward(new ToughDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 3.0),
				new Reward(new LuckyDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 3.0),
				new Reward(new StrongDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 3.0),
				new Reward(new HealingDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 3.0),
				new Reward(new HealthyDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 3.0),

				new Reward(new Beef(100).getUpdatedItem(false).asQuantity(16), 40.0),

				new Reward(new CrackedRegenerationGem(0).getUpdatedItem(false), 2.0),
				new Reward(new CrackedStrengthGem(0).getUpdatedItem(false), 2.0),
				new Reward(new CrackedLuckGem(0).getUpdatedItem(false), 2.0),
				new Reward(new CrackedToughGem(0).getUpdatedItem(false), 2.0),
				new Reward(new CrackedHealthGem(0).getUpdatedItem(false), 2.0),
				new Reward(new FlawedRegenerationGem(0).getUpdatedItem(false), 5.0),
				new Reward(new FlawedStrengthGem(0).getUpdatedItem(false), 5.0),
				new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 5.0),
				new Reward(new FlawedToughGem(0).getUpdatedItem(false), 5.0),
				new Reward(new FlawedHealthGem(0).getUpdatedItem(false), 5.0),

				new Reward(new MobKey(0).getUpdatedItem(false).asQuantity(4), 100.0),
				});
	}

}