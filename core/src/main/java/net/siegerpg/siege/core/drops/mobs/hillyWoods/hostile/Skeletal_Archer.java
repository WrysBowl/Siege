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
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.ReinforcedBow;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.crossbows.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.reinforcedBows.*;
import net.siegerpg.siege.core.items.implemented.weapons.wands.FlamingHotTorch;
import net.siegerpg.siege.core.miscellaneous.Utils;


public class Skeletal_Archer extends MobDropTable {

	public Skeletal_Archer() {

		super("Skeletal_Archer", 60, 70, 80, 90, new Reward[] {
				new Reward(new Bone()
						           .getUpdatedItem(false)
						           .asQuantity(4), 100.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 10.0),
				new Reward(new Bone()
						           .getUpdatedItem(false), 0.30),

				new Reward(new BoneHelmet(50).getUpdatedItem(false), 1.0),
				new Reward(new BoneChestplate(50).getUpdatedItem(false), 1.0),
				new Reward(new BoneLeggings(50).getUpdatedItem(false), 1.0),
				new Reward(new BoneBoots(50).getUpdatedItem(false), 1.0),

				new Reward(new BoneHelmet(Utils.randRarity()).getUpdatedItem(false), 0.30),
				new Reward(new BoneChestplate(Utils.randRarity()).getUpdatedItem(false), 0.30),
				new Reward(new BoneLeggings(Utils.randRarity()).getUpdatedItem(false), 0.30),
				new Reward(new BoneBoots(Utils.randRarity()).getUpdatedItem(false), 0.30),

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

				new Reward(new Crossbow(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealingCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new HealthyCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new ToughCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new StrongCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.25),
				new Reward(new LuckyCrossbow(Utils.randRarity()).getUpdatedItem(false), 0.25),

				new Reward(new ReinforcedBow(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealingReinforcedBow(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealthyReinforcedBow(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ToughReinforcedBow(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new StrongReinforcedBow(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new LuckyReinforcedBow(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new FlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new MobKey(0).getUpdatedItem(false), 0.50),
				new Reward(new FoxSpiritKey().getUpdatedItem(false), 0.30),

				});
	}

}
