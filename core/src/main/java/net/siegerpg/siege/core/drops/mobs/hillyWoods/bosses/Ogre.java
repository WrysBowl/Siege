package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.BoneBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.boneBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.boots.magmaBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.boneChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.magmaChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.boneHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.magmaHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoneLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.boneLeggings.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.magmaLeggings.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.NecromancerKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.GreatSword;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.greatSwords.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Ogre extends MobDropTable {

	public Ogre() {

		super("Ogre", 250, 300, 300, 325, new Reward[] {
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(3), 40.0),
				new Reward(Leather.Companion
						           .tier(3)
						           .getUpdatedItem(false), 6.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(3), 60.0),
				new Reward(Bone.Companion
						           .tier(3)
						           .getUpdatedItem(false), 6.0),

				new Reward(new BoneHelmet(80).getUpdatedItem(false), 2.5),
				new Reward(new BoneChestplate(80).getUpdatedItem(false), 2.5),
				new Reward(new BoneLeggings(80).getUpdatedItem(false), 2.5),
				new Reward(new BoneBoots(80).getUpdatedItem(false), 2.5),

				new Reward(new ToughBoneHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new ToughBoneChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new ToughBoneLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new ToughBoneBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new HealingBoneHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new HealingBoneChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new HealingBoneLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new HealingBoneBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new HealthyBoneHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new HealthyBoneChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new HealthyBoneLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new HealthyBoneBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new StrongBoneHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new StrongBoneChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new StrongBoneLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new StrongBoneBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new LuckyBoneHelmet(50).getUpdatedItem(false), 0.2),
				new Reward(new LuckyBoneChestplate(50).getUpdatedItem(false), 0.2),
				new Reward(new LuckyBoneLeggings(50).getUpdatedItem(false), 0.2),
				new Reward(new LuckyBoneBoots(50).getUpdatedItem(false), 0.2),

				new Reward(new BoneHelmet(Utils.randRarity()).getUpdatedItem(false), 3.0),
				new Reward(new BoneChestplate(Utils.randRarity()).getUpdatedItem(false), 3.0),
				new Reward(new BoneLeggings(Utils.randRarity()).getUpdatedItem(false), 3.0),
				new Reward(new BoneBoots(Utils.randRarity()).getUpdatedItem(false), 3.0),

				new Reward(new ToughBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new HealingBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new HealthyBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new StrongBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new LuckyBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyBoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new GreatSword(100).getUpdatedItem(false), 0.5),
				new Reward(new LuckyGreatSword(80).getUpdatedItem(false), 0.2),
				new Reward(new ToughGreatSword(80).getUpdatedItem(false), 0.2),
				new Reward(new StrongGreatSword(80).getUpdatedItem(false), 0.2),
				new Reward(new HealingGreatSword(80).getUpdatedItem(false), 0.2),
				new Reward(new HealthyGreatSword(80).getUpdatedItem(false), 0.2),

				new Reward(new GreatSword(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new LuckyGreatSword(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new ToughGreatSword(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new StrongGreatSword(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealingGreatSword(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealthyGreatSword(Utils.randRarity()).getUpdatedItem(false), 0.25),

				new Reward(new NecromancerKey(0).getUpdatedItem(false), 10.0),
				});
	}

}