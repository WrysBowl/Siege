package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.IronBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.IronChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.IronHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.IronLeggings;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.BroodmotherKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.RefinedDagger;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Mercenary extends MobDropTable {

	public Mercenary() {

		super("Mercenary", 55, 58, 75, 78, new Reward[] {
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false), 50.0),
				new Reward(Leather.Companion
						           .tier(3)
						           .getUpdatedItem(false), 5.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false), 50.0),
				new Reward(Bone.Companion
						           .tier(3)
						           .getUpdatedItem(false), 5.0),
				new Reward(MetalScrap.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(3), 25.0),
				new Reward(MetalScrap.Companion
						           .tier(3)
						           .getUpdatedItem(false), 5.0),

				new Reward(new IronHelmet(80).getUpdatedItem(false), 2.5),
				new Reward(new IronChestplate(80).getUpdatedItem(false), 2.5),
				new Reward(new IronLeggings(80).getUpdatedItem(false), 2.5),
				new Reward(new IronBoots(80).getUpdatedItem(false), 2.5),

				new Reward(new IronHelmet(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new IronChestplate(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new IronLeggings(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new IronBoots(Utils.randRarity()).getUpdatedItem(false), 2.5),

				new Reward(new RefinedDagger(50).getUpdatedItem(false), 3.0),
				new Reward(new RefinedDagger(Utils.randRarity()).getUpdatedItem(false), 5.0),

				new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 2.0),
				new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 1.0),
				new Reward(new BroodmotherKey(0).getUpdatedItem(false), 10.0),
				});
	}

}
