package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import org.bukkit.Material;

public class JUNGLE_LOG extends BlockDropTable {
    public JUNGLE_LOG() {
        super(100, Material.JUNGLE_LOG, 1, 3, 1, 3, new Reward[]{
                new Reward(Stick.Companion.tier(1).getUpdatedItem(false), 100.0),
                new Reward(Stick.Companion.tier(2).getUpdatedItem(false), 10.0)
        });
    }
}