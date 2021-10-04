package net.siegerpg.siege.core.drops.mobs.hillyWoods.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;

public class Pigeon extends MobDropTable {
    public Pigeon() {
        super("Pigeon", 2, 5, 3, 6, new Reward[]{
                new Reward(Feather.Companion.tier(1).getUpdatedItem(false), 60.0),
                new Reward(Feather.Companion.tier(2).getUpdatedItem(false), 6.0),
                new Reward(new Drumstick(0).getUpdatedItem(false), 50.0),
        });
    }
}