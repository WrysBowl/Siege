package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import org.bukkit.Material;

public class GREEN_CONCRETE extends BlockDropTable {
    public GREEN_CONCRETE() {
        super(100, Material.GREEN_CONCRETE, 1, 1, 0, 0, new Reward[]{
                new Reward(PlantMatter.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(Seed.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(PlantMatter.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(Seed.Companion.tier(2).getUpdatedItem(false), 5.0)
        });
    }
}
