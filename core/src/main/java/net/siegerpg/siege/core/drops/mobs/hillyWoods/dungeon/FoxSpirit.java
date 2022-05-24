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
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.PolishedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.PristineHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PolishedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PristineLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.PolishedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.PristineRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PolishedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PristineStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PolishedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PristineToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.ScrapShard;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.SplinteredBone;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.scrapShards.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.splinteredBones.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class FoxSpirit extends MobDropTable {

	public FoxSpirit() {

		super("FoxSpirit", 7500, 12500, 20000, 25000, new Reward[] {

				new Reward(new Bone().getUpdatedItem(false), 60.0),
				new Reward(new Bone().getUpdatedItem(false).asQuantity(8), 10.20),

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

				new Reward(new SplinteredBone(100).getUpdatedItem(false), 1.0),
				new Reward(new SplinteredBone(Utils.randRarity()).getUpdatedItem(false), 20.05),
				new Reward(new LuckySplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.20),
				new Reward(new ToughSplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.20),
				new Reward(new StrongSplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.20),
				new Reward(new HealingSplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.20),
				new Reward(new HealthySplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.20),

				new Reward(new ScrapShard(100).getUpdatedItem(false), 1.0),
				new Reward(new ScrapShard(Utils.randRarity()).getUpdatedItem(false), 20.05),
				new Reward(new LuckyScrapShard(Utils.randRarity()).getUpdatedItem(false), 0.20),
				new Reward(new ToughScrapShard(Utils.randRarity()).getUpdatedItem(false), 0.20),
				new Reward(new StrongScrapShard(Utils.randRarity()).getUpdatedItem(false), 0.20),
				new Reward(new HealingScrapShard(Utils.randRarity()).getUpdatedItem(false), 0.20),
				new Reward(new HealthyScrapShard(Utils.randRarity()).getUpdatedItem(false), 0.20),

				new Reward(new PristineRegenerationGem(0).getUpdatedItem(false), 0.20),
				new Reward(new PristineStrengthGem(0).getUpdatedItem(false), 0.20),
				new Reward(new PristineLuckGem(0).getUpdatedItem(false), 0.20),
				new Reward(new PristineToughGem(0).getUpdatedItem(false), 0.20),
				new Reward(new PristineHealthGem(0).getUpdatedItem(false), 0.20),
				new Reward(new PolishedRegenerationGem(0).getUpdatedItem(false), 1.0),
				new Reward(new PolishedStrengthGem(0).getUpdatedItem(false), 1.0),
				new Reward(new PolishedLuckGem(0).getUpdatedItem(false), 1.0),
				new Reward(new PolishedToughGem(0).getUpdatedItem(false), 1.0),
				new Reward(new PolishedHealthGem(0).getUpdatedItem(false), 1.0),

				new Reward(new FoxyHelmet().getUpdatedItem(false), 0.50),
				new Reward(new FoxyChestplate().getUpdatedItem(false), 0.50),
				new Reward(new FoxyLeggings().getUpdatedItem(false), 0.50),
				new Reward(new FoxyBoots().getUpdatedItem(false), 0.50),

				new Reward(new MobKey(0).getUpdatedItem(false).asQuantity(8), 100.0),

				});
	}

}