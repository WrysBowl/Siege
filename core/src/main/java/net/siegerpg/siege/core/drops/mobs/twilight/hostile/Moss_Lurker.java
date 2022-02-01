package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Ectoplasm;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PolishedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PolishedToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.wands.CrystalCane;
import net.siegerpg.siege.core.miscellaneous.Utils;


public class Moss_Lurker extends MobDropTable {

	public Moss_Lurker() {

		super("Moss_Lurker", 200, 300, 250, 350, new Reward[] {
				new Reward(new Ectoplasm().getUpdatedItem(false)
				                          .asQuantity(4), 25.0),
				new Reward(new Ectoplasm().getUpdatedItem(false), 1.5),
				new Reward(new FairyDust().getUpdatedItem(false)
						           .asQuantity(16), 25.0),
				new Reward(new FairyDust().getUpdatedItem(false)
						           .asQuantity(4), 1.5),

				new Reward(new PolishedToughGem(0).getUpdatedItem(false), 0.75),
				new Reward(new PolishedStrengthGem(0).getUpdatedItem(false), 0.25),
				new Reward(new CrystalCane(Utils.randRarity()).getUpdatedItem(false), 1.0),
				});
	}

}
