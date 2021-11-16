package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Carrot;
import org.bukkit.Material;

public class CARROTS extends BlockDropTable {

	public CARROTS() {

		super(200, Material.CARROTS, 0, 0, 0, 1, new Reward[] {
				new Reward(new Carrot(0)
						           .getUpdatedItem(false)
						           .asQuantity(1), 100.0),
				});
	}

}
