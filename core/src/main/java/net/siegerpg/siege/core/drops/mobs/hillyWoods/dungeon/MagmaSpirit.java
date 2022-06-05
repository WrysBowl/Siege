package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.*;
import net.siegerpg.siege.core.items.implemented.armor.boots.magmaBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.magmaChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.magmaHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.magmaLeggings.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma;
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
import net.siegerpg.siege.core.items.implemented.weapons.wands.Torch;
import net.siegerpg.siege.core.items.implemented.weapons.wands.torches.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class MagmaSpirit extends MobDropTable {

	public MagmaSpirit() {

		super("MagmaSpirit", 1500, 1800, 1000, 1500, new Reward[] {
				new Reward(new Magma().getUpdatedItem(false), 100.0),
				new Reward(new Magma().getUpdatedItem(false).asQuantity(8), 10.0),

				new Reward(new MagmaHelmet(100).getUpdatedItem(false), 1.0),
				new Reward(new MagmaChestplate(100).getUpdatedItem(false), 1.0),
				new Reward(new MagmaLeggings(100).getUpdatedItem(false), 1.0),
				new Reward(new MagmaBoots(100).getUpdatedItem(false), 1.0),

				new Reward(new MagmaHelmet(80).getUpdatedItem(false), 15.0),
				new Reward(new MagmaChestplate(80).getUpdatedItem(false), 15.0),
				new Reward(new MagmaLeggings(80).getUpdatedItem(false), 15.0),
				new Reward(new MagmaBoots(80).getUpdatedItem(false), 15.0),

				new Reward(new ToughMagmaHelmet(50).getUpdatedItem(false), 1.5),
				new Reward(new ToughMagmaChestplate(50).getUpdatedItem(false), 1.5),
				new Reward(new ToughMagmaLeggings(50).getUpdatedItem(false), 1.5),
				new Reward(new ToughMagmaBoots(50).getUpdatedItem(false), 1.5),

				new Reward(new HealingMagmaHelmet(50).getUpdatedItem(false), 1.5),
				new Reward(new HealingMagmaChestplate(50).getUpdatedItem(false), 1.5),
				new Reward(new HealingMagmaLeggings(50).getUpdatedItem(false), 1.5),
				new Reward(new HealingMagmaBoots(50).getUpdatedItem(false), 1.5),

				new Reward(new HealthyMagmaHelmet(50).getUpdatedItem(false), 1.5),
				new Reward(new HealthyMagmaChestplate(50).getUpdatedItem(false), 1.5),
				new Reward(new HealthyMagmaLeggings(50).getUpdatedItem(false), 1.5),
				new Reward(new HealthyMagmaBoots(50).getUpdatedItem(false), 1.5),

				new Reward(new StrongMagmaHelmet(50).getUpdatedItem(false), 1.5),
				new Reward(new StrongMagmaChestplate(50).getUpdatedItem(false), 1.5),
				new Reward(new StrongMagmaLeggings(50).getUpdatedItem(false), 1.5),
				new Reward(new StrongMagmaBoots(50).getUpdatedItem(false), 1.5),

				new Reward(new LuckyMagmaHelmet(50).getUpdatedItem(false), 1.5),
				new Reward(new LuckyMagmaChestplate(50).getUpdatedItem(false), 1.5),
				new Reward(new LuckyMagmaLeggings(50).getUpdatedItem(false), 1.5),
				new Reward(new LuckyMagmaBoots(50).getUpdatedItem(false), 1.5),

				new Reward(new MagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new MagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new MagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new MagmaBoots(Utils.randRarity()).getUpdatedItem(false), 15.0),

				new Reward(new ToughMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new HealingMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealingMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealingMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealingMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new HealthyMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealthyMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealthyMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealthyMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new StrongMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new StrongMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new StrongMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new StrongMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new LuckyMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new LuckyMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new LuckyMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new LuckyMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new Torch(100).getUpdatedItem(false), 1.5),
				new Reward(new Torch(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new LuckyTorch(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughTorch(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new StrongTorch(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealingTorch(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealthyTorch(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new CrackedRegenerationGem(0).getUpdatedItem(false), 1.0),
				new Reward(new CrackedStrengthGem(0).getUpdatedItem(false), 1.0),
				new Reward(new CrackedLuckGem(0).getUpdatedItem(false), 1.0),
				new Reward(new CrackedToughGem(0).getUpdatedItem(false), 1.0),
				new Reward(new CrackedHealthGem(0).getUpdatedItem(false), 1.0),
				new Reward(new FlawedRegenerationGem(0).getUpdatedItem(false), 0.20),
				new Reward(new FlawedStrengthGem(0).getUpdatedItem(false), 0.20),
				new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 0.20),
				new Reward(new FlawedToughGem(0).getUpdatedItem(false), 0.20),
				new Reward(new FlawedHealthGem(0).getUpdatedItem(false), 0.20),

				new Reward(new MagmarsCrown(Utils.randRarity()).getUpdatedItem(false), 0.50),
				new Reward(new MagmarsChestplate(Utils.randRarity()).getUpdatedItem(false), 0.50),
				new Reward(new MagmarsLeggings(Utils.randRarity()).getUpdatedItem(false), 0.50),
				new Reward(new MagmarsTrekkers(Utils.randRarity()).getUpdatedItem(false), 0.50),

				new Reward(new MobKey().getUpdatedItem(false).asQuantity(2), 7.5),
				new Reward(new MobKey().getUpdatedItem(false).asQuantity(2), 7.5),
				new Reward(new MobKey().getUpdatedItem(false).asQuantity(2), 7.5),

				});
	}

}