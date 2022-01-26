package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick;
import org.bukkit.Material;

public class STRIPPED_JUNGLE_LOG extends BlockDropTable {

	public STRIPPED_JUNGLE_LOG() {

		super(100, Material.STRIPPED_JUNGLE_LOG, 1, 3, 1, 3, new Reward[] {
				new Reward(new Stick()
						           .getUpdatedItem(false), 100.0),
				new Reward(new Stick()
						           .getUpdatedItem(false), 10.0)
		});
	}

}
