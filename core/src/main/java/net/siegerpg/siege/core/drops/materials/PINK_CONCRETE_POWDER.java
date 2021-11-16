package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import org.bukkit.Material;

public class PINK_CONCRETE_POWDER extends BlockDropTable {
	public PINK_CONCRETE_POWDER () {
		super(80, Material.PINK_CONCRETE_POWDER, 1, 2, 1, 2, new Reward[] {
				new Reward(Crystal.Companion.tier(1).getUpdatedItem(false), 50.0),
				new Reward(Crystal.Companion.tier(2).getUpdatedItem(false), 5.0),
				new Reward(FairyDust.Companion.tier(1).getUpdatedItem(false), 75.0),
				new Reward(FairyDust.Companion.tier(2).getUpdatedItem(false), 7.5),
				new Reward(CorruptCrystal.Companion.tier(1).getUpdatedItem(false), 5.0),
		});
	}
}
