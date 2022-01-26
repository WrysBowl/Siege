package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MagicVine;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.SparklingLeaves;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick;
import org.bukkit.Material;

public class STRIPPED_WARPED_HYPHAE extends BlockDropTable {

	public STRIPPED_WARPED_HYPHAE() {

		super(180, Material.STRIPPED_WARPED_HYPHAE, 3, 5, 2, 4, new Reward[] {
				new Reward(new MagicVine()
						           .getUpdatedItem(false), 50.0),
				new Reward(new MagicVine()
						           .getUpdatedItem(false), 5.0),
				new Reward(new SparklingLeaves()
						           .getUpdatedItem(false), 60.0),
				new Reward(new SparklingLeaves()
						           .getUpdatedItem(false), 6.0),
				new Reward(new Stick()
						           .getUpdatedItem(false), 100.0),
				new Reward(new Stick()
						           .getUpdatedItem(false), 10.0),
				});
	}

}
