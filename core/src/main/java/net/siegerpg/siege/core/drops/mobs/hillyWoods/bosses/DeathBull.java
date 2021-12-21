package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.LeatherBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.hardenedLeatherBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.LeatherChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.hardenedLeatherChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.LeatherHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.hardenedLeatherHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.LeatherLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.hardenedLeatherLeggings.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*;
import net.siegerpg.siege.core.items.implemented.misc.food.Beef;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.doubleBladedAxes.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class DeathBull extends MobDropTable {

	public DeathBull() {

		super("DeathBull", 37, 40, 46, 49, new Reward[] {
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false), 80.0),
				new Reward(Leather.Companion
						           .tier(3)
						           .getUpdatedItem(false), 8.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false), 50.0),
				new Reward(Bone.Companion
						           .tier(3)
						           .getUpdatedItem(false), 5.0),

				new Reward(new LeatherHelmet(80).getUpdatedItem(false), 1.5),
				new Reward(new LeatherChestplate(80).getUpdatedItem(false), 1.5),
				new Reward(new LeatherLeggings(80).getUpdatedItem(false), 1.5),
				new Reward(new LeatherBoots(80).getUpdatedItem(false), 1.5),

				new Reward(new ToughHardenedLeatherHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new ToughHardenedLeatherChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new ToughHardenedLeatherLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new ToughHardenedLeatherBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new HealingHardenedLeatherHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new HealingHardenedLeatherChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new HealingHardenedLeatherLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new HealingHardenedLeatherBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new HealthyHardenedLeatherHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new HealthyHardenedLeatherChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new HealthyHardenedLeatherLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new HealthyHardenedLeatherBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new StrongHardenedLeatherHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new StrongHardenedLeatherChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new StrongHardenedLeatherLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new StrongHardenedLeatherBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new LuckyHardenedLeatherHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new LuckyHardenedLeatherChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new LuckyHardenedLeatherLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new LuckyHardenedLeatherBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

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

				new Reward(new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new LuckyDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new StrongDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealingDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealthyDoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 0.25),

				new Reward(new Beef(100).getUpdatedItem(false), 40.0),
				new Reward(new BullSpiritKey(0).getUpdatedItem(false), 10.0),
				new Reward(new MobKey(0).getUpdatedItem(false), 1.0),

				});
	}

}
