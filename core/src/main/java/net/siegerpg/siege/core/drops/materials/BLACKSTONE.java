package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import org.bukkit.Material;

public class BLACKSTONE extends BlockDropTable {
    public BLACKSTONE() {
        super(180, Material.BLACKSTONE, 3, 5, 2, 4, new Reward[]{
                new Reward(CharredStick.Companion.tier(1).getUpdatedItem(false), 100.0),
                new Reward(CharredStick.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(Pebble.Companion.tier(1).getUpdatedItem(false), 40.0),
                new Reward(Pebble.Companion.tier(2).getUpdatedItem(false), 4.0),
                new Reward(Stick.Companion.tier(1).getUpdatedItem(false), 30.0),
                new Reward(Stick.Companion.tier(2).getUpdatedItem(false), 3.0)
        });
    }
}
