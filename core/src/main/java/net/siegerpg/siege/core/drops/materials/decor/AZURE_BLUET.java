package net.siegerpg.siege.core.drops.materials.decor;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick;
import org.bukkit.Material;

public class AZURE_BLUET extends BlockDropTable {

	public AZURE_BLUET () {

		super(100, Material.AZURE_BLUET, 0, 0, 0, 0, new Reward[] {
				new Reward(Seed.Companion.tier(1).getUpdatedItem(false), 25.0),
				new Reward(PlantMatter.Companion.tier(1).getUpdatedItem(false), 25.0),
				new Reward(Stick.Companion.tier(1).getUpdatedItem(false), 25.0),
				new Reward(Seed.Companion.tier(2).getUpdatedItem(false), 2.5),
				new Reward(PlantMatter.Companion.tier(2).getUpdatedItem(false), 2.5),
				new Reward(Stick.Companion.tier(2).getUpdatedItem(false), 2.5)
		});
	}

}
