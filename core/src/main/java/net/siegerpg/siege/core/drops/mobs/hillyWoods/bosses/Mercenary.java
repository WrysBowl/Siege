package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.*;
import net.siegerpg.siege.core.items.implemented.armor.boots.ironBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.ironChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.ironHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.IronLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.ironleggings.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.items.implemented.weapons.wands.slimeSpoofers.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Mercenary extends MobDropTable {

	public Mercenary() {

		super("Mercenary", 55, 58, 75, 78, new Reward[] {
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false), 50.0),
				new Reward(Leather.Companion
						           .tier(3)
						           .getUpdatedItem(false), 5.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false), 50.0),
				new Reward(Bone.Companion
						           .tier(3)
						           .getUpdatedItem(false), 5.0),
				new Reward(MetalScrap.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(3), 25.0),
				new Reward(MetalScrap.Companion
						           .tier(3)
						           .getUpdatedItem(false), 5.0),

				new Reward(new IronHelmet(80).getUpdatedItem(false), 2.5),
				new Reward(new IronChestplate(80).getUpdatedItem(false), 2.5),
				new Reward(new IronLeggings(80).getUpdatedItem(false), 2.5),
				new Reward(new IronBoots(80).getUpdatedItem(false), 2.5),

				new Reward(new ToughIronHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new ToughIronChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new ToughIronLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new ToughIronBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new HealingIronHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new HealingIronChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new HealingIronLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new HealingIronBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new HealthyIronHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new HealthyIronChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new HealthyIronLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new HealthyIronBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new StrongIronHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new StrongIronChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new StrongIronLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new StrongIronBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new LuckyIronHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new LuckyIronChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new LuckyIronLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new LuckyIronBoots(50).getUpdatedItem(false), 0.2),
				
				new Reward(new IronHelmet(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new IronChestplate(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new IronLeggings(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new IronBoots(Utils.randRarity()).getUpdatedItem(false), 2.5),

				new Reward(new ToughIronHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughIronChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughIronLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughIronBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new HealingIronHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingIronChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingIronLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingIronBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new HealthyIronHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyIronChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyIronLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyIronBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new StrongIronHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongIronChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongIronLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongIronBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new LuckyIronHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyIronChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyIronLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyIronBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),
				
				new Reward(new RefinedDagger(50).getUpdatedItem(false), 2.0),
				new Reward(new LuckyRefinedDagger(80).getUpdatedItem(false), 0.2),
				new Reward(new ToughRefinedDagger(80).getUpdatedItem(false), 0.2),
				new Reward(new StrongRefinedDagger(80).getUpdatedItem(false), 0.2),
				new Reward(new HealingRefinedDagger(80).getUpdatedItem(false), 0.2),
				new Reward(new HealthyRefinedDagger(80).getUpdatedItem(false), 0.2),
				new Reward(new RefinedDagger(Utils.randRarity()).getUpdatedItem(false), 3.0),
				new Reward(new LuckyRefinedDagger(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new ToughRefinedDagger(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new StrongRefinedDagger(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealingRefinedDagger(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealthyRefinedDagger(Utils.randRarity()).getUpdatedItem(false), 0.25),

				new Reward(new BroodmotherKey(0).getUpdatedItem(false), 3.0),
				new Reward(new MobKey(0).getUpdatedItem(false), 1.0),

				});
	}

}
