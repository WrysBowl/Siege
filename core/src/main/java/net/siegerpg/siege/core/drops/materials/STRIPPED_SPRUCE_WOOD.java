package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick;
import org.bukkit.Material;

public class STRIPPED_SPRUCE_WOOD extends BlockDropTable {

	public STRIPPED_SPRUCE_WOOD() {

		super(100, Material.STRIPPED_SPRUCE_WOOD, 1, 3, 1, 3, new Reward[] {
				new Reward(new Stick()
						           .getUpdatedItem(false), 100.0),
				new Reward(new Stick()
						           .getUpdatedItem(false), 10.0)
		});
	}

}
