package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.LeatherBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.LeatherChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.LeatherHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.LeatherLeggings;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.CrackedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shank;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Thief extends MobDropTable {

	public Thief() {

		super("Thief", 25, 28, 35, 38, new Reward[] {
				new Reward(Leather.Companion
						           .tier(1)
						           .getUpdatedItem(false), 30.0),
				new Reward(Leather.Companion
						           .tier(2)
						           .getUpdatedItem(false), 3.0),
				new Reward(Bone.Companion
						           .tier(1)
						           .getUpdatedItem(false), 40.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false), 4.0),

				new Reward(new LeatherHelmet(30).getUpdatedItem(false), 4.5),
				new Reward(new LeatherChestplate(30).getUpdatedItem(false), 4.5),
				new Reward(new LeatherLeggings(30).getUpdatedItem(false), 4.5),
				new Reward(new LeatherBoots(30).getUpdatedItem(false), 4.5),

				new Reward(new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false), 0.5),
				new Reward(new LeatherBoots(Utils.randRarity()).getUpdatedItem(false), 0.5),

				new Reward(new Shank(50).getUpdatedItem(false), 3.0),
				new Reward(new Shank(Utils.randRarity()).getUpdatedItem(false), 5.0),

				new Reward(new CrackedStrengthGem(0).getUpdatedItem(false), 2.0),
				new Reward(new FlawedStrengthGem(0).getUpdatedItem(false), 1.0),
				});
	}

}
