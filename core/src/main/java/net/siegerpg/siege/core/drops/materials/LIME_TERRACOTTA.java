package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed;
import org.bukkit.Material;

public class LIME_TERRACOTTA extends BlockDropTable {

	public LIME_TERRACOTTA() {

		super(100, Material.LIME_TERRACOTTA, 1, 1, 0, 0, new Reward[] {
				new Reward(new PlantMatter()
						           .getUpdatedItem(false), 60.0),
				new Reward(new Seed()
						           .getUpdatedItem(false), 60.0),
				new Reward(new PlantMatter()
						           .getUpdatedItem(false), 6.0),
				new Reward(new Seed()
						           .getUpdatedItem(false), 6.0)
		});
	}

}
