package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import org.bukkit.Material;

public class SNOW extends BlockDropTable {
    public SNOW() {
        super(80, Material.SNOW, 1, 2, 1, 2, new Reward[]{
                new Reward(IceShard.Companion.tier(1).getUpdatedItem(false), 30.0),
                new Reward(IceShard.Companion.tier(2).getUpdatedItem(false), 3.0),
                new Reward(Crystal.Companion.tier(1).getUpdatedItem(false), 5.0),
                new Reward(Crystal.Companion.tier(2).getUpdatedItem(false), 0.5)
        });
    }
}
