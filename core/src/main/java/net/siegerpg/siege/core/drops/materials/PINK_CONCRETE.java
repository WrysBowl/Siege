package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import org.bukkit.Material;

public class PINK_CONCRETE extends BlockDropTable {

	public PINK_CONCRETE () {

		super(150, Material.PINK_CONCRETE, 2, 4, 2, 3, new Reward[] {
				new Reward(Crystal.Companion.tier(1).getUpdatedItem(false), 100.0),
				new Reward(Crystal.Companion.tier(2).getUpdatedItem(false), 10.0),
				new Reward(FairyDust.Companion.tier(1).getUpdatedItem(false), 60.0),
				new Reward(FairyDust.Companion.tier(2).getUpdatedItem(false), 6.0),
				new Reward(CorruptCrystal.Companion.tier(1).getUpdatedItem(false), 5.0),

				});
	}

}
