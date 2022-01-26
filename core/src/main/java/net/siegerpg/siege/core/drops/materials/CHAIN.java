package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Chain;
import org.bukkit.Material;

public class CHAIN extends BlockDropTable {

	public CHAIN() {

		super(40, Material.CHAIN, 0, 0, 0, 0, new Reward[] {
				new Reward(new Chain().getUpdatedItem(false), 100.0)
		});
	}

}
