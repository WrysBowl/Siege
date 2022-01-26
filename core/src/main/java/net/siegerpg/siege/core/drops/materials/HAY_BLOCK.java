package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat;
import org.bukkit.Material;

public class HAY_BLOCK extends BlockDropTable {

	public HAY_BLOCK() {

		super(100, Material.HAY_BLOCK, 3, 5, 3, 4, new Reward[] {
				new Reward(new Wheat()
						           .getUpdatedItem(false)
						           .asQuantity(3), 100.0),
				new Reward(new Wheat()
						           .getUpdatedItem(false), 10.0)
		});
	}

}
