package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.*;
import net.siegerpg.siege.core.items.implemented.armor.boots.chainBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.chainChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.chainHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.chainLeggings.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.PolishedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PolishedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.PolishedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PolishedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PolishedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.RecurveBow;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.recurveBows.*;
import net.siegerpg.siege.core.items.implemented.weapons.wands.EarthernWand;
import net.siegerpg.siege.core.items.implemented.weapons.wands.earthernWands.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Necromancer extends MobDropTable {

	public Necromancer() {

		super("Necromancer", 5000, 10000, 40000, 45000, new Reward[] {

				new Reward(new Bone().getUpdatedItem(false), 60.0),
				new Reward(new Bone().getUpdatedItem(false).asQuantity(8), 1.5),
				new Reward(new MetalScrap().getUpdatedItem(false), 60.0),
				new Reward(new MetalScrap().getUpdatedItem(false).asQuantity(8), 1.5),

				new Reward(new ChainHelmet(100).getUpdatedItem(false), 1.0),
				new Reward(new ChainChestplate(100).getUpdatedItem(false), 1.0),
				new Reward(new ChainLeggings(100).getUpdatedItem(false), 1.0),
				new Reward(new ChainBoots(100).getUpdatedItem(false), 1.0),

				new Reward(new ChainHelmet(80).getUpdatedItem(false), 20.05),
				new Reward(new ChainChestplate(80).getUpdatedItem(false), 20.05),
				new Reward(new ChainLeggings(80).getUpdatedItem(false), 20.05),
				new Reward(new ChainBoots(80).getUpdatedItem(false), 20.05),

				new Reward(new ToughChainHelmet(50).getUpdatedItem(false), 0.10),
				new Reward(new ToughChainChestplate(50).getUpdatedItem(false), 0.10),
				new Reward(new ToughChainLeggings(50).getUpdatedItem(false), 0.10),
				new Reward(new ToughChainBoots(50).getUpdatedItem(false), 0.10),

				new Reward(new HealingChainHelmet(50).getUpdatedItem(false), 0.10),
				new Reward(new HealingChainChestplate(50).getUpdatedItem(false), 0.10),
				new Reward(new HealingChainLeggings(50).getUpdatedItem(false), 0.10),
				new Reward(new HealingChainBoots(50).getUpdatedItem(false), 0.10),

				new Reward(new HealthyChainHelmet(50).getUpdatedItem(false), 0.10),
				new Reward(new HealthyChainChestplate(50).getUpdatedItem(false), 0.10),
				new Reward(new HealthyChainLeggings(50).getUpdatedItem(false), 0.10),
				new Reward(new HealthyChainBoots(50).getUpdatedItem(false), 0.10),

				new Reward(new StrongChainHelmet(50).getUpdatedItem(false), 0.10),
				new Reward(new StrongChainChestplate(50).getUpdatedItem(false), 0.10),
				new Reward(new StrongChainLeggings(50).getUpdatedItem(false), 0.10),
				new Reward(new StrongChainBoots(50).getUpdatedItem(false), 0.10),

				new Reward(new LuckyChainHelmet(50).getUpdatedItem(false), 0.10),
				new Reward(new LuckyChainChestplate(50).getUpdatedItem(false), 0.10),
				new Reward(new LuckyChainLeggings(50).getUpdatedItem(false), 0.10),
				new Reward(new LuckyChainBoots(50).getUpdatedItem(false), 0.10),

				new Reward(new ChainHelmet(Utils.randRarity()).getUpdatedItem(false), 30.0),
				new Reward(new ChainChestplate(Utils.randRarity()).getUpdatedItem(false), 30.0),
				new Reward(new ChainLeggings(Utils.randRarity()).getUpdatedItem(false), 30.0),
				new Reward(new ChainBoots(Utils.randRarity()).getUpdatedItem(false), 30.0),

				new Reward(new ToughChainHelmet(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new ToughChainChestplate(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new ToughChainLeggings(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new ToughChainBoots(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new HealingChainHelmet(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingChainChestplate(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingChainLeggings(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingChainBoots(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new HealthyChainHelmet(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyChainChestplate(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyChainLeggings(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyChainBoots(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new StrongChainHelmet(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongChainChestplate(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongChainLeggings(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongChainBoots(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new LuckyChainHelmet(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new LuckyChainChestplate(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new LuckyChainLeggings(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new LuckyChainBoots(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new IronAxe(100).getUpdatedItem(false), 2.5),
				new Reward(new IronAxe(Utils.randRarity()).getUpdatedItem(false), 21.0),
				new Reward(new LuckyIronAxe(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new ToughIronAxe(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongIronAxe(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingIronAxe(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyIronAxe(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new EarthernWand(Utils.randRarity()).getUpdatedItem(false), 11.0),
				new Reward(new EarthernWand(100).getUpdatedItem(false), 1.0),
				new Reward(new EarthernWand(80).getUpdatedItem(false), 11.0),
				new Reward(new LuckyEarthernWand(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new ToughEarthernWand(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongEarthernWand(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingEarthernWand(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyEarthernWand(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new RecurveBow(100).getUpdatedItem(false), 2.5),
				new Reward(new RecurveBow(Utils.randRarity()).getUpdatedItem(false), 21.0),
				new Reward(new LuckyRecurveBow(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new ToughRecurveBow(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongRecurveBow(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingRecurveBow(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyRecurveBow(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 0.20),
				new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 0.20),
				new Reward(new SimpleLuckGem(0).getUpdatedItem(false), 0.20),
				new Reward(new SimpleToughGem(0).getUpdatedItem(false), 0.20),
				new Reward(new SimpleHealthGem(0).getUpdatedItem(false), 0.20),
				new Reward(new PolishedRegenerationGem(0).getUpdatedItem(false), 1.0),
				new Reward(new PolishedStrengthGem(0).getUpdatedItem(false), 1.0),
				new Reward(new PolishedLuckGem(0).getUpdatedItem(false), 1.0),
				new Reward(new PolishedToughGem(0).getUpdatedItem(false), 1.0),
				new Reward(new PolishedHealthGem(0).getUpdatedItem(false), 1.0),

				new Reward(new NecromancerHood().getUpdatedItem(false), 0.50),
				new Reward(new NecromancerCloak().getUpdatedItem(false), 0.50),
				new Reward(new NecromancerLeggings().getUpdatedItem(false), 0.50),
				new Reward(new NecromancerFootpads().getUpdatedItem(false), 0.50),

				new Reward(new MobKey(0).getUpdatedItem(false).asQuantity(7), 100.0),

				});
	}

}