package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import org.bukkit.Material;

public class IRON_ORE extends BlockDropTable {
	public IRON_ORE () {
		super(300, Material.IRON_ORE, 8, 10, 3, 5, new Reward[] {
				new Reward(MetalScrap.Companion.tier(1).getUpdatedItem(false).asQuantity(3), 100.0),
				new Reward(MetalScrap.Companion.tier(2).getUpdatedItem(false), 10.0),
				new Reward(MetalScrap.Companion.tier(3).getUpdatedItem(false), 1.0)
		});
	}
}
