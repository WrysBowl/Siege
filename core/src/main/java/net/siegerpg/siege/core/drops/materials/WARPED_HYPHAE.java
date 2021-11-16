package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MagicVine;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.SparklingLeaves;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick;
import org.bukkit.Material;

public class WARPED_HYPHAE extends BlockDropTable {
	public WARPED_HYPHAE () {
		super(180, Material.WARPED_HYPHAE, 3, 5, 2, 4, new Reward[] {
				new Reward(MagicVine.Companion.tier(1).getUpdatedItem(false), 50.0),
				new Reward(MagicVine.Companion.tier(2).getUpdatedItem(false), 5.0),
				new Reward(SparklingLeaves.Companion.tier(1).getUpdatedItem(false), 60.0),
				new Reward(SparklingLeaves.Companion.tier(2).getUpdatedItem(false), 6.0),
				new Reward(Stick.Companion.tier(1).getUpdatedItem(false), 100.0),
				new Reward(Stick.Companion.tier(2).getUpdatedItem(false), 10.0),
		});
	}
}
