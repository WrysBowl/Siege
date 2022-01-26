package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed;
import org.bukkit.Material;

public class GREEN_TERRACOTTA extends BlockDropTable {

	public GREEN_TERRACOTTA() {

		super(100, Material.GREEN_TERRACOTTA, 1, 1, 0, 0, new Reward[] {
				new Reward(new PlantMatter()
						           .getUpdatedItem(false), 65.0),
				new Reward(new Seed()
						           .getUpdatedItem(false), 35.0),
				new Reward(new PlantMatter()
						           .getUpdatedItem(false), 6.5),
				new Reward(new Seed()
						           .getUpdatedItem(false), 3.5)
		});
	}

}
