package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CursedBone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;


public class Dark_Elf extends MobDropTable {
	public Dark_Elf () {
		super("Dark_Elf", 50, 60, 50, 60, new Reward[] {
				new Reward(FairyDust.Companion.tier(1).getUpdatedItem(false), 60.0),
				new Reward(FairyDust.Companion.tier(2).getUpdatedItem(false), 10.0),
				new Reward(CorruptCrystal.Companion.tier(1).getUpdatedItem(false), 25.0),
				new Reward(CorruptCrystal.Companion.tier(2).getUpdatedItem(false), 5.0),
				new Reward(CursedBone.Companion.tier(1).getUpdatedItem(false), 25.0),
				new Reward(CursedBone.Companion.tier(2).getUpdatedItem(false), 5.0),

				new Reward(new FlawedToughGem(0).getUpdatedItem(false), 1.0),
				new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 0.5),
		});
	}
}
