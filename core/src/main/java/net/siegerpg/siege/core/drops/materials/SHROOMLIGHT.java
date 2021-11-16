package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.ShroomPowder;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.SparklingLeaves;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import org.bukkit.Material;

public class SHROOMLIGHT extends BlockDropTable {

	public SHROOMLIGHT () {

		super(200, Material.SHROOMLIGHT, 3, 5, 2, 4, new Reward[] {
				new Reward(ShroomPowder.Companion.tier(1).getUpdatedItem(false), 100.0),
				new Reward(ShroomPowder.Companion.tier(2).getUpdatedItem(false), 10.0),
				new Reward(FairyDust.Companion.tier(1).getUpdatedItem(false), 20.0),
				new Reward(FairyDust.Companion.tier(2).getUpdatedItem(false), 2.0),
				new Reward(SparklingLeaves.Companion.tier(1).getUpdatedItem(false), 5.0),
				});
	}

}
