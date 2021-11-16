package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.BoneBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoneLeggings;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.DavyJonesKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.DoubleBladedAxe;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Orc extends MobDropTable {

	public Orc () {

		super("Orc", 55, 59, 60, 64, new Reward[] {
				new Reward(Leather.Companion.tier(2).getUpdatedItem(false).asQuantity(2), 50.0),
				new Reward(Leather.Companion.tier(3).getUpdatedItem(false), 5.0),
				new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(2), 40.0),
				new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 5.0),

				new Reward(new BoneHelmet(50).getUpdatedItem(false), 0.5),
				new Reward(new BoneChestplate(50).getUpdatedItem(false), 0.5),
				new Reward(new BoneLeggings(50).getUpdatedItem(false), 0.5),
				new Reward(new BoneBoots(50).getUpdatedItem(false), 0.5),

				new Reward(new BoneHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new BoneChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new BoneLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new BoneBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new DoubleBladedAxe(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new DoubleBladedAxe(100).getUpdatedItem(false), 0.5),

				new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 0.25),
				new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 1.0),
				new Reward(new DavyJonesKey(0).getUpdatedItem(false), 10.0),
				});
	}

}
