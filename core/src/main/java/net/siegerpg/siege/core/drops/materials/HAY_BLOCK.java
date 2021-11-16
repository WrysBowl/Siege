package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat;
import org.bukkit.Material;

public class HAY_BLOCK extends BlockDropTable {

	public HAY_BLOCK () {

		super(100, Material.HAY_BLOCK, 3, 5, 3, 4, new Reward[] {
				new Reward(Wheat.Companion.tier(1).getUpdatedItem(false).asQuantity(3), 100.0),
				new Reward(Wheat.Companion.tier(2).getUpdatedItem(false), 10.0)
		});
	}

}
