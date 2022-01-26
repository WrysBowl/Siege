package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import org.bukkit.Material;

public class PINK_STAINED_GLASS extends BlockDropTable {

	public PINK_STAINED_GLASS() {

		super(60, Material.PINK_STAINED_GLASS, 2, 4, 3, 5, new Reward[] {
				new Reward(new Crystal()
						           .getUpdatedItem(false), 80.0),
				new Reward(new Crystal()
						           .getUpdatedItem(false), 8.0),
				new Reward(new FairyDust()
						           .getUpdatedItem(false), 50.0),
				new Reward(new FairyDust()
						           .getUpdatedItem(false), 5.0),
				new Reward(new CorruptCrystal()
						           .getUpdatedItem(false), 5.0),
				});
	}

}
