package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.BoneBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoneLeggings;
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

		super("Skeletal_Warrior", 80, 90, 60, 70, new Reward[] {
				new Reward(Bone.Companion
						           .tier(1)
						           .getUpdatedItem(false)
						           .asQuantity(4), 100.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false), 10.0),
				new Reward(Bone.Companion
						           .tier(3)
						           .getUpdatedItem(false), 1.0),

				new Reward(new BoneHelmet(50).getUpdatedItem(false), 2.5),
				new Reward(new BoneChestplate(50).getUpdatedItem(false), 2.5),
				new Reward(new BoneLeggings(50).getUpdatedItem(false), 2.5),
				new Reward(new BoneBoots(50).getUpdatedItem(false), 2.5),

				new Reward(new BoneHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new BoneChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new BoneLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new BoneBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new WoodenSword(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new HealingWoodenSword(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new HealthyWoodenSword(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new ToughWoodenSword(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new StrongWoodenSword(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new LuckyWoodenSword(Utils.randRarity()).getUpdatedItem(false), 2.5),

				new Reward(new ScrapShard(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealingScrapShard(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealthyScrapShard(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughScrapShard(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new StrongScrapShard(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new LuckyScrapShard(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new SplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(
						new HealingSplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(
						new HealthySplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new ToughSplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new StrongSplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new LuckySplinteredBone(Utils.randRarity()).getUpdatedItem(false), 0.5),

				});
	}

}
