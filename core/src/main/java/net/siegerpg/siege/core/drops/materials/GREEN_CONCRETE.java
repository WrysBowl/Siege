package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed;
import org.bukkit.Material;

public class GREEN_CONCRETE extends BlockDropTable {

	public GREEN_CONCRETE() {

		super(100, Material.GREEN_CONCRETE, 1, 1, 0, 0, new Reward[] {
				new Reward(new PlantMatter()
						           .getUpdatedItem(false), 50.0),
				new Reward(new Seed()
						           .getUpdatedItem(false), 50.0),
				new Reward(new PlantMatter()
						           .getUpdatedItem(false), 5.0),
				new Reward(new Seed()
						           .getUpdatedItem(false), 5.0)
		});
	}

}
