package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import org.bukkit.Material;

public class WHEAT extends BlockDropTable {
    public WHEAT() {
        super(400, Material.WHEAT, 0, 0, 0, 1, new Reward[]{
                new Reward(Wheat.Companion.tier(1).getUpdatedItem(false), 100.0),
                new Reward(Wheat.Companion.tier(2).getUpdatedItem(false), 10.0)
        });
    }
}
