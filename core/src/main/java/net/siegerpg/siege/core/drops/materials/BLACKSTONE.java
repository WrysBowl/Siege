package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.CharredStick;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick;
import org.bukkit.Material;

public class BLACKSTONE extends BlockDropTable {

	public BLACKSTONE() {

		super(180, Material.BLACKSTONE, 3, 5, 2, 4, new Reward[] {
				new Reward(new CharredStick().getUpdatedItem(false), 100.0),
				new Reward(new Pebble().getUpdatedItem(false), 60.0),
				new Reward(new Stick().getUpdatedItem(false), 30.0)
		});
	}

}
