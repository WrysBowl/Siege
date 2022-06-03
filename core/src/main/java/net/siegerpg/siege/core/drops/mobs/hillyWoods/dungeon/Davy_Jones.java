package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.*;
import net.siegerpg.siege.core.items.implemented.armor.boots.boneBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.boneChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.boneHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.boneLeggings.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
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
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.WarHammer;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.warHammers.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Trident;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Tridents.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Davy_Jones extends MobDropTable {

	public Davy_Jones() {

		super("Davy_Jones", 5000, 7500, 10000, 12000, new Reward[] {
				new Reward(new Bone().getUpdatedItem(false), 100.0),
				new Reward(new Bone().getUpdatedItem(false).asQuantity(8), 21.0),

				new Reward(new Trident(100).getUpdatedItem(false), 1.0),
				new Reward(new Trident(80).getUpdatedItem(false), 15.0),
				new Reward(new LuckyTrident(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughTrident(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new StrongTrident(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealingTrident(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealthyTrident(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new WarHammer(100).getUpdatedItem(false), 1.5),
				new Reward(new WarHammer(80).getUpdatedItem(false), 1.50),
				new Reward(new LuckyWarHammer(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughWarHammer(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new StrongWarHammer(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealingWarHammer(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealthyWarHammer(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new BoneHelmet(100).getUpdatedItem(false), 1.0),
				new Reward(new BoneChestplate(100).getUpdatedItem(false), 1.0),
				new Reward(new BoneLeggings(100).getUpdatedItem(false), 1.0),
				new Reward(new BoneBoots(100).getUpdatedItem(false), 1.0),

				new Reward(new BoneHelmet(80).getUpdatedItem(false), 15.0),
				new Reward(new BoneChestplate(80).getUpdatedItem(false), 15.0),
				new Reward(new BoneLeggings(80).getUpdatedItem(false), 15.0),
				new Reward(new BoneBoots(80).getUpdatedItem(false), 15.0),

				new Reward(new ToughBoneHelmet(50).getUpdatedItem(false), 1.5),
				new Reward(new ToughBoneChestplate(50).getUpdatedItem(false), 1.5),
				new Reward(new ToughBoneLeggings(50).getUpdatedItem(false), 1.5),
				new Reward(new ToughBoneBoots(50).getUpdatedItem(false), 1.5),

				new Reward(new HealingBoneHelmet(50).getUpdatedItem(false), 1.5),
				new Reward(new HealingBoneChestplate(50).getUpdatedItem(false), 1.5),
				new Reward(new HealingBoneLeggings(50).getUpdatedItem(false), 1.5),
				new Reward(new HealingBoneBoots(50).getUpdatedItem(false), 1.5),

				new Reward(new HealthyBoneHelmet(50).getUpdatedItem(false), 1.5),
				new Reward(new HealthyBoneChestplate(50).getUpdatedItem(false), 1.5),
				new Reward(new HealthyBoneLeggings(50).getUpdatedItem(false), 1.5),
				new Reward(new HealthyBoneBoots(50).getUpdatedItem(false), 1.5),

				new Reward(new StrongBoneHelmet(50).getUpdatedItem(false), 1.5),
				new Reward(new StrongBoneChestplate(50).getUpdatedItem(false), 1.5),
				new Reward(new StrongBoneLeggings(50).getUpdatedItem(false), 1.5),
				new Reward(new StrongBoneBoots(50).getUpdatedItem(false), 1.5),

				new Reward(new LuckyBoneHelmet(50).getUpdatedItem(false), 1.5),
				new Reward(new LuckyBoneChestplate(50).getUpdatedItem(false), 1.5),
				new Reward(new LuckyBoneLeggings(50).getUpdatedItem(false), 1.5),
				new Reward(new LuckyBoneBoots(50).getUpdatedItem(false), 1.5),

				new Reward(new BoneHelmet(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new BoneChestplate(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new BoneLeggings(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new BoneBoots(Utils.randRarity()).getUpdatedItem(false), 15.0),

				new Reward(new ToughBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughBoneBoots(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new HealingBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealingBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealingBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealingBoneBoots(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new HealthyBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealthyBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealthyBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealthyBoneBoots(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new StrongBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new StrongBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new StrongBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new StrongBoneBoots(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new LuckyBoneHelmet(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new LuckyBoneChestplate(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new LuckyBoneLeggings(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new LuckyBoneBoots(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 1.0),
				new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 1.0),
				new Reward(new SimpleLuckGem(0).getUpdatedItem(false), 1.0),
				new Reward(new SimpleToughGem(0).getUpdatedItem(false), 1.0),
				new Reward(new SimpleHealthGem(0).getUpdatedItem(false), 1.0),
				new Reward(new PolishedRegenerationGem(0).getUpdatedItem(false), 0.20),
				new Reward(new PolishedStrengthGem(0).getUpdatedItem(false), 0.20),
				new Reward(new PolishedLuckGem(0).getUpdatedItem(false), 0.20),
				new Reward(new PolishedToughGem(0).getUpdatedItem(false), 0.20),
				new Reward(new PolishedHealthGem(0).getUpdatedItem(false), 0.20),

				new Reward(new DavyCap(Utils.randRarity()).getUpdatedItem(false), 0.50),
				new Reward(new DavyTunic(Utils.randRarity()).getUpdatedItem(false), 0.50),
				new Reward(new DavyLeggings(Utils.randRarity()).getUpdatedItem(false), 0.50),
				new Reward(new DavyBoots(Utils.randRarity()).getUpdatedItem(false), 0.50),

				new Reward(new MobKey().getUpdatedItem(false).asQuantity(2), 10.0),
				new Reward(new MobKey().getUpdatedItem(false).asQuantity(2), 10.0),
				new Reward(new MobKey().getUpdatedItem(false).asQuantity(2), 10.0),

				});
	}

}