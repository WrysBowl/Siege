package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.IceShard;
import org.bukkit.Material;

public class ICE extends BlockDropTable {

	public ICE() {

		super(80, Material.ICE, 1, 3, 1, 3, new Reward[] {
				new Reward(new IceShard().getUpdatedItem(false), 100.0),
				new Reward(new Crystal().getUpdatedItem(false), 20.0)
		});
	}

}
