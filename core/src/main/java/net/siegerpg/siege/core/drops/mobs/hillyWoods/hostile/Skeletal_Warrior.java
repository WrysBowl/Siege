package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.BoneBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.boneBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.boneChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.boneHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoneLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.boneLeggings.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.FoxSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PolishedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.ScrapShard;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.SplinteredBone;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.WoodenSword;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.scrapShards.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.splinteredBones.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.woodenSwords.*;
import net.siegerpg.siege.core.miscellaneous.Utils;


public class Skeletal_Warrior extends MobDropTable {

	public Skeletal_Warrior() {

		super("Skeletal_Warrior", 80, 90, 160, 165, new Reward[] {
				new Reward(new Bone()
						           .getUpdatedItem(false)
						           .asQuantity(4), 100.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 10.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 0.10),

				new Reward(new BoneHelmet(50).getUpdatedItem(false), 0.25),
				new Reward(new BoneChestplate(50).getUpdatedItem(false), 0.25),
				new Reward(new BoneLeggings(50).getUpdatedItem(false), 0.25),
				new Reward(new BoneBoots(50).getUpdatedItem(false), 0.25),

				new Reward(new BoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new BoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new BoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new BoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new ToughBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new ToughBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new ToughBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new ToughBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.01),

				new Reward(new HealingBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new HealingBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new HealingBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new HealingBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.01),

				new Reward(new HealthyBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new HealthyBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new HealthyBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new HealthyBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.01),

				new Reward(new StrongBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new StrongBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new StrongBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new StrongBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.01),

				new Reward(new LuckyBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new LuckyBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new LuckyBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.01),
				new Reward(new LuckyBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.01),

				new Reward(new WoodenSword(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealingWoodenSword(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealthyWoodenSword(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new ToughWoodenSword(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new StrongWoodenSword(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new LuckyWoodenSword(Utils.randRarity()).getUpdatedItem(false), 0.25),

				new Reward(new ScrapShard(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealingScrapShard(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new HealthyScrapShard(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new ToughScrapShard(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongScrapShard(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new LuckyScrapShard(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new SplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(
						new HealingSplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(
						new HealthySplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new ToughSplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new StrongSplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.10),
				new Reward(new LuckySplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.10),

				new Reward(new MobKey(0).getUpdatedItem(false), 3.0),
				new Reward(new FoxSpiritKey().getUpdatedItem(false), 2.5),

				});
	}

}
