package net.siegerpg.siege.core.drops.mobs.hillyWoods.passive;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.leggings.BeePants;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.utils.Utils;

public class FeatheredMeat extends MobDropTable {
    public FeatheredMeat() {
        super("FeatheredMeat", 4, 7, 5, 8, new Reward[]{
                new Reward(Feather.Companion.tier(1).getUpdatedItem(false), 100.0),
                new Reward(Feather.Companion.tier(2).getUpdatedItem(false), 25.0),
                new Reward(new Drumstick(50).getUpdatedItem(false), 5.0),
                new Reward(new Drumstick(0).getUpdatedItem(false), 25.0)
        });
    }
}