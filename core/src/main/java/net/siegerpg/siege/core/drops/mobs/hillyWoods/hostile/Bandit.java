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
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.BroodmotherKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Dagger;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.daggers.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Bandit extends MobDropTable {

	public Bandit() {

		super("Bandit", 35, 38, 240, 240, new Reward[] {
				new Reward(new Leather()
						           .getUpdatedItem(false), 50.0),
				new Reward(new Leather()
						           .getUpdatedItem(false), 1.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 50.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 1.0),
				new Reward(new MetalScrap()
						           .getUpdatedItem(false), 21.0),

				new Reward(new LeatherHelmet(50).getUpdatedItem(false), 0.75),
				new Reward(new LeatherChestplate(50).getUpdatedItem(false), 0.75),
				new Reward(new LeatherLeggings(50).getUpdatedItem(false), 0.75),
				new Reward(new LeatherBoots(50).getUpdatedItem(false), 0.75),

				new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.25),

				new Reward(new ToughHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new ToughHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new ToughHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new ToughHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new HealingHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new HealthyHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new StrongHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new LuckyHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new LuckyHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new LuckyHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new LuckyHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new Dagger(50).getUpdatedItem(false), 0.50),
				new Reward(new Dagger(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ToughDagger(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new LuckyDagger(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongDagger(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingDagger(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyDagger(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new MobKey(0).getUpdatedItem(false), 1.0),
				new Reward(new BroodmotherKey(0).getUpdatedItem(false), 1.0),

				});
	}

}
