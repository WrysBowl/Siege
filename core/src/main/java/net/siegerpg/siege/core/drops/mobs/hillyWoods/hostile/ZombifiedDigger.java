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
import net.siegerpg.siege.core.items.implemented.misc.food.Beetroot;
import net.siegerpg.siege.core.items.implemented.misc.food.SusStew;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.NecromancerKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.miscellaneous.Utils;


public class ZombifiedDigger extends MobDropTable {

	public ZombifiedDigger() {

		super("ZombifiedDigger", 50, 53, 57, 60, new Reward[] {
				new Reward(Leather.Companion
						           .tier(1)
						           .getUpdatedItem(false), 25.0),
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false), 5.0),
				new Reward(Bone.Companion
						           .tier(1)
						           .getUpdatedItem(false), 60.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false), 6.0),

				new Reward(new BoneHelmet(50).getUpdatedItem(false), 2.5),
				new Reward(new BoneChestplate(50).getUpdatedItem(false), 2.5),
				new Reward(new BoneLeggings(50).getUpdatedItem(false), 2.5),
				new Reward(new BoneBoots(50).getUpdatedItem(false), 2.5),

				new Reward(new BoneHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new BoneChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new BoneLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new BoneBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new ToughBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new ToughBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new ToughBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new ToughBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.05),

				new Reward(new HealingBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealingBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealingBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealingBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.05),

				new Reward(new HealthyBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealthyBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealthyBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealthyBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.05),

				new Reward(new StrongBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new StrongBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new StrongBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new StrongBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.05),

				new Reward(new LuckyBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new LuckyBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new LuckyBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new LuckyBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.05),

				new Reward(new Beetroot().getUpdatedItem(false), 10.0),
				new Reward(new Beetroot().getUpdatedItem(false), 50.0),
				new Reward(new SusStew().getUpdatedItem(false), 10.0),

				new Reward(new MobKey(0).getUpdatedItem(false), 2.5),
				new Reward(new NecromancerKey(0).getUpdatedItem(false), 1.0),

				});
	}

}
