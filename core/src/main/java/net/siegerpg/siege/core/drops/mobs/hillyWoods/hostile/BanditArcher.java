package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class BanditArcher extends MobDropTable {

	public BanditArcher () {

		super("BanditArcher", 30, 34, 62, 66, new Reward[] {
				new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 50.0),
				new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 5.0),
				new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 50.0),
				new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 5.0),
				new Reward(MetalScrap.Companion.tier(1).getUpdatedItem(false), 25.0),

				new Reward(new Crossbow(100).getUpdatedItem(false), 0.5),
				new Reward(new Crossbow(Utils.randRarity()).getUpdatedItem(false), 2.5),

				new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 2.0),
				new Reward(new SimpleLuckGem(0).getUpdatedItem(false), 1.0),
				new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 1.0),
				});
	}

}
