package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine;
import org.bukkit.Material;

public class VINE extends BlockDropTable {

	public VINE() {

		super(40, Material.VINE, 0, 0, 0, 0, new Reward[] {
				new Reward(Vine.Companion
						           .tier(1)
						           .getUpdatedItem(false), 100.0),
				new Reward(Vine.Companion
						           .tier(2)
						           .getUpdatedItem(false), 10.0),
				new Reward(Vine.Companion
						           .tier(3)
						           .getUpdatedItem(false), 0.1)
		});
	}

}
