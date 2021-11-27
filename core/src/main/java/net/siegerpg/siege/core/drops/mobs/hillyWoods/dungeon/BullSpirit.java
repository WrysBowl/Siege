package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.LeatherBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.LeatherChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.LeatherHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.LeatherLeggings;
import net.siegerpg.siege.core.items.implemented.misc.food.Beef;
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
import net.siegerpg.siege.core.miscellaneous.Utils;

public class BullSpirit extends MobDropTable {

	public BullSpirit() {

		super("BullSpirit", 2500, 2700, 7500, 9100, new Reward[] {
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

				new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 20.0),

				new Reward(new DoubleBladedAxe(100).getUpdatedItem(false), 7.5),
				new Reward(new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 25.5),

				new Reward(new Beef(100)
						           .getUpdatedItem(false)
						           .asQuantity(16), 40.0),

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
				});
	}

}