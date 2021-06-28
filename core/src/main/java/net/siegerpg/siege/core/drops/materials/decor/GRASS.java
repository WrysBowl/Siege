package net.siegerpg.siege.core.drops.materials.decor;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import org.bukkit.Material;

public class GRASS extends BlockDropTable {
    public GRASS() {
        super(100, Material.GRASS, 0, 0, 0, 0, new Reward[]{
                new Reward(Seed.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(PlantMatter.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(Stick.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(Seed.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(PlantMatter.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(Stick.Companion.tier(2).getUpdatedItem(false), 5.0)
        });
    }
}
