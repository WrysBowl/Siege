package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar;
import org.bukkit.Material;

public class SUGAR_CANE extends BlockDropTable {

	public SUGAR_CANE () {

		super(20, Material.SUGAR_CANE, 0, 0, 0, 0, new Reward[] {
				new Reward(new Sugar(0).getUpdatedItem(false), 2.5)
		});
	}

}
