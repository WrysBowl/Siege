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
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.FoxSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.CrackedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Dagger;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shank;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.daggers.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.shanks.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Thief extends MobDropTable {

	public Thief() {

		super("Thief", 25, 28, 35, 38, new Reward[] {
				new Reward(Leather.Companion
						           .tier(1)
						           .getUpdatedItem(false), 30.0),
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false), 3.0),
				new Reward(Bone.Companion
						           .tier(1)
						           .getUpdatedItem(false), 40.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false), 4.0),

				new Reward(new LeatherHelmet(30).getUpdatedItem(false), 4.5),
				new Reward(new LeatherChestplate(30).getUpdatedItem(false), 4.5),
				new Reward(new LeatherLeggings(30).getUpdatedItem(false), 4.5),
				new Reward(new LeatherBoots(30).getUpdatedItem(false), 4.5),

				new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.5),

				new Reward(new ToughHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new HealingHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new HealthyHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new StrongHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new LuckyHardenedLeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyHardenedLeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyHardenedLeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyHardenedLeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new Shank(50).getUpdatedItem(false), 3.0),
				new Reward(new Shank(Utils.randRarity()).getUpdatedItem(false), 5.0),
				new Reward(new ToughShank(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new LuckyShank(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new StrongShank(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new HealingShank(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new HealthyShank(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new FoxSpiritKey(0).getUpdatedItem(false), 1.0),

				});
	}

}
