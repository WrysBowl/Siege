package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import org.bukkit.Material;

public class PINK_STAINED_GLASS extends BlockDropTable {

	public PINK_STAINED_GLASS () {

		super(60, Material.PINK_STAINED_GLASS, 2, 4, 3, 5, new Reward[] {
				new Reward(Crystal.Companion.tier(1).getUpdatedItem(false), 80.0),
				new Reward(Crystal.Companion.tier(2).getUpdatedItem(false), 8.0),
				new Reward(FairyDust.Companion.tier(1).getUpdatedItem(false), 50.0),
				new Reward(FairyDust.Companion.tier(2).getUpdatedItem(false), 5.0),
				new Reward(CorruptCrystal.Companion.tier(1).getUpdatedItem(false), 5.0),
				});
	}

}
