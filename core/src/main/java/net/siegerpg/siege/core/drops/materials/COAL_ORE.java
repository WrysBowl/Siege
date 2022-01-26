package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Coal;
import org.bukkit.Material;

public class COAL_ORE extends BlockDropTable {

	public COAL_ORE() {

		super(200, Material.COAL_ORE, 3, 5, 8, 10, new Reward[] {
				new Reward(new Coal().getUpdatedItem(false).asQuantity(3), 100.0)
		});
	}

}
