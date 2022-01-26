package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat;
import org.bukkit.Material;

public class WHEAT extends BlockDropTable {

	public WHEAT() {

		super(400, Material.WHEAT, 0, 0, 0, 1, new Reward[] {
				new Reward(new Wheat()
						           .getUpdatedItem(false), 100.0),
				new Reward(new Wheat()
						           .getUpdatedItem(false), 10.0)
		});
	}

}
