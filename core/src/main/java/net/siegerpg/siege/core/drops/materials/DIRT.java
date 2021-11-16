package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import org.bukkit.Material;

public class DIRT extends BlockDropTable {

	public DIRT () {

		super(100, Material.DIRT, 1, 1, 0, 0, new Reward[] {
				new Reward(Pebble.Companion.tier(1).getUpdatedItem(false), 50.0),
				new Reward(Pebble.Companion.tier(2).getUpdatedItem(false), 5.0)
		});
	}

}
