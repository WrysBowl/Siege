package net.siegerpg.siege.core.drops.mobs.twilight.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;


public class Crystal_Turtle extends MobDropTable {
    public Crystal_Turtle() {
        super("Crystal_Turtle", 210, 230, 230, 240, new Reward[]{
                new Reward(Crystal.Companion.tier(1).getUpdatedItem(false).asQuantity(16), 75.0),
                new Reward(Crystal.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 25.0),
                new Reward(Crystal.Companion.tier(3).getUpdatedItem(false).asQuantity(4), 5.0),
                new Reward(FairyDust.Companion.tier(2).getUpdatedItem(false).asQuantity(16), 35.0),
                new Reward(FairyDust.Companion.tier(3).getUpdatedItem(false).asQuantity(4), 5.0),
        });
    }
}