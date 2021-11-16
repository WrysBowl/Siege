package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.IceShard;
import org.bukkit.Material;

public class ICE extends BlockDropTable {

	public ICE () {

		super(80, Material.ICE, 1, 3, 1, 3, new Reward[] {
				new Reward(IceShard.Companion.tier(1).getUpdatedItem(false), 100.0),
				new Reward(IceShard.Companion.tier(2).getUpdatedItem(false), 10.0),
				new Reward(Crystal.Companion.tier(1).getUpdatedItem(false), 20.0),
				new Reward(Crystal.Companion.tier(2).getUpdatedItem(false), 2.0)
		});
	}

}
