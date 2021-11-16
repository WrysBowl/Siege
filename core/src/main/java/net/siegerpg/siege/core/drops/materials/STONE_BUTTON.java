package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import org.bukkit.Material;

public class STONE_BUTTON extends BlockDropTable {

	public STONE_BUTTON () {

		super(200, Material.STONE_BUTTON, 0, 0, 1, 1, new Reward[] {
				new Reward(Pebble.Companion.tier(1).getUpdatedItem(false), 50.0),
				new Reward(Pebble.Companion.tier(2).getUpdatedItem(false), 5.0)
		});
	}

}
