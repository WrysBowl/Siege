package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.MagmaBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.MagmaChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.MagmaHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.MagmaLeggings;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.RawRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.RawStrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.wands.MatchStick;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class ScorchingBlob extends MobDropTable {

	public ScorchingBlob() {

		super("ScorchingBlob", 6, 9, 11, 14, new Reward[] {
				new Reward(Magma.Companion
						           .tier(1)
						           .getUpdatedItem(false), 100.0),
				new Reward(Magma.Companion
						           .tier(2)
						           .getUpdatedItem(false), 10.0),

				new Reward(new MagmaHelmet(50).getUpdatedItem(false), 2.0),
				new Reward(new MagmaChestplate(50).getUpdatedItem(false), 2.0),
				new Reward(new MagmaLeggings(50).getUpdatedItem(false), 2.0),
				new Reward(new MagmaBoots(50).getUpdatedItem(false), 2.0),

				new Reward(new MagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new MagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new MagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new MagmaBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new MatchStick(Utils.randRarity()).getUpdatedItem(false), 2.0),

				new Reward(new RawStrengthGem(0).getUpdatedItem(false), 2.0),
				new Reward(new RawRegenerationGem(0).getUpdatedItem(false), 2.0),
				});
	}

}
