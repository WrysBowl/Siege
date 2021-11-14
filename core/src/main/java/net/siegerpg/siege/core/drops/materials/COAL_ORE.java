package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import org.bukkit.Material;

public class COAL_ORE extends BlockDropTable {
    public COAL_ORE() {
        super(200, Material.COAL_ORE, 3, 5, 8, 10, new Reward[]{
                new Reward(Coal.Companion.tier(1).getUpdatedItem(false).asQuantity(3), 100.0),
                new Reward(Coal.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(Coal.Companion.tier(3).getUpdatedItem(false), 1.0)
        });
    }
}
