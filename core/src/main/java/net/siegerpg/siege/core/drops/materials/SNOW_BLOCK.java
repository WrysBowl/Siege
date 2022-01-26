package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.IceShard;
import org.bukkit.Material;

public class SNOW_BLOCK extends BlockDropTable {

	public SNOW_BLOCK() {

		super(80, Material.SNOW_BLOCK, 2, 4, 1, 2, new Reward[] {
				new Reward(new IceShard()
						           .getUpdatedItem(false), 60.0),
				new Reward(new IceShard()
						           .getUpdatedItem(false), 6.0),
				new Reward(new Crystal()
						           .getUpdatedItem(false), 10.0),
				new Reward(new Crystal()
						           .getUpdatedItem(false), 10.0)
		});
	}

}
