package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.IceShard;
import org.bukkit.Material;

public class SNOW extends BlockDropTable {

	public SNOW() {

		super(80, Material.SNOW, 1, 2, 1, 2, new Reward[] {
				new Reward(new IceShard()
						           .getUpdatedItem(false), 30.0),
				new Reward(new IceShard()
						           .getUpdatedItem(false), 3.0),
				new Reward(new Crystal()
						           .getUpdatedItem(false), 5.0),
				new Reward(new Crystal()
						           .getUpdatedItem(false), 0.5)
		});
	}

}
