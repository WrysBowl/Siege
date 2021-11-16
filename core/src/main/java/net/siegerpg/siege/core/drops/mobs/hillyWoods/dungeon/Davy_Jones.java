package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.BoneBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoneLeggings;
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
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Trident;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Davy_Jones extends MobDropTable {

	public Davy_Jones() {

		super("Davy_Jones", 9000, 10000, 9000, 10000, new Reward[] {
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(8), 100.0),
				new Reward(Bone.Companion
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

				new Reward(new Trident(100).getUpdatedItem(false), 5.0),
				new Reward(new Trident(80).getUpdatedItem(false), 20.0),

				new Reward(new WarHammer(100).getUpdatedItem(false), 5.0),
				new Reward(new WarHammer(80).getUpdatedItem(false), 20.0),

				new Reward(new BoneHelmet(100).getUpdatedItem(false), 5.5),
				new Reward(new BoneChestplate(100).getUpdatedItem(false), 5.5),
				new Reward(new BoneLeggings(100).getUpdatedItem(false), 5.5),
				new Reward(new BoneBoots(100).getUpdatedItem(false), 5.5),

				new Reward(new BoneHelmet(80).getUpdatedItem(false), 25.5),
				new Reward(new BoneChestplate(80).getUpdatedItem(false), 25.5),
				new Reward(new BoneLeggings(80).getUpdatedItem(false), 25.5),
				new Reward(new BoneBoots(80).getUpdatedItem(false), 25.5),

				new Reward(new BoneHelmet(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new BoneChestplate(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new BoneLeggings(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new BoneBoots(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new BoneHelmet(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new BoneChestplate(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new BoneLeggings(Utils.randRarity()).getUpdatedItem(false), 20.0),
				new Reward(new BoneBoots(Utils.randRarity()).getUpdatedItem(false), 20.0),

				new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 10.0),
				new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 10.0),
				new Reward(new SimpleLuckGem(0).getUpdatedItem(false), 10.0),
				new Reward(new SimpleToughGem(0).getUpdatedItem(false), 10.0),
				new Reward(new SimpleHealthGem(0).getUpdatedItem(false), 10.0),
				new Reward(new PolishedRegenerationGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PolishedStrengthGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PolishedLuckGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PolishedToughGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PolishedHealthGem(0).getUpdatedItem(false), 5.0),
				});
	}

}