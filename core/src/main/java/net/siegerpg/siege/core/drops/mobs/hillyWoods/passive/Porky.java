package net.siegerpg.siege.core.drops.mobs.hillyWoods.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.HillyWoodsDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;

public class Porky extends MobDropTable {
    public Porky() {
        super("Porky", 6, 9, 8, 11, new Reward[]{
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(new Porkchop(50).getUpdatedItem(false), 60.0),
                new Reward(new Porkchop(100).getUpdatedItem(false), 6.0),
        });
    }
}