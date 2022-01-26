package net.siegerpg.siege.core.drops.materials.decor;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick;
import org.bukkit.Material;

public class WHITE_TULIP extends BlockDropTable {

	public WHITE_TULIP() {

		super(100, Material.WHITE_TULIP, 0, 0, 0, 0, new Reward[] {
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
