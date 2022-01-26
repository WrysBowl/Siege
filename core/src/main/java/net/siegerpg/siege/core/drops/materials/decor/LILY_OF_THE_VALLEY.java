package net.siegerpg.siege.core.drops.materials.decor;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick;
import org.bukkit.Material;

public class LILY_OF_THE_VALLEY extends BlockDropTable {

	public LILY_OF_THE_VALLEY() {

		super(100, Material.LILY_OF_THE_VALLEY, 0, 0, 0, 0, new Reward[] {
				new Reward(new Seed()
						           .getUpdatedItem(false), 25.0),
				new Reward(new PlantMatter()
						           .getUpdatedItem(false), 25.0),
				new Reward(new Stick()
						           .getUpdatedItem(false), 25.0),
				new Reward(new Seed()
						           .getUpdatedItem(false), 2.5),
				new Reward(new PlantMatter()
						           .getUpdatedItem(false), 2.5),
				new Reward(new Stick()
						           .getUpdatedItem(false), 2.5)
		});
	}

}
