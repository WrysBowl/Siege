package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import org.bukkit.Material;

public class LIGHT_GRAY_CONCRETE extends BlockDropTable {

	public LIGHT_GRAY_CONCRETE() {

		super(100, Material.LIGHT_GRAY_CONCRETE, 1, 1, 0, 0, new Reward[] {
				new Reward(Pebble.Companion
						           .tier(1)
						           .getUpdatedItem(false), 100.0),
				new Reward(Pebble.Companion
						           .tier(2)
						           .getUpdatedItem(false), 10.0),
				new Reward(Pebble.Companion
						           .tier(3)
						           .getUpdatedItem(false), 0.1)
		});
	}

}
