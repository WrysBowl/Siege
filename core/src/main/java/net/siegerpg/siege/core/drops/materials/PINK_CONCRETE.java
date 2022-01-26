package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import org.bukkit.Material;

public class PINK_CONCRETE extends BlockDropTable {

	public PINK_CONCRETE() {

		super(150, Material.PINK_CONCRETE, 2, 4, 2, 3, new Reward[] {
				new Reward(new Crystal()
						           .getUpdatedItem(false), 100.0),
				new Reward(new Crystal()
						           .getUpdatedItem(false), 10.0),
				new Reward(new FairyDust()
						           .getUpdatedItem(false), 60.0),
				new Reward(new FairyDust()
						           .getUpdatedItem(false), 6.0),
				new Reward(new CorruptCrystal()
						           .getUpdatedItem(false), 5.0),

				});
	}

}
