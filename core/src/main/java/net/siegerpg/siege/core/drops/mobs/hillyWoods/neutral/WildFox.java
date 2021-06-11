package net.siegerpg.siege.core.drops.mobs.hillyWoods.neutral;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.leggings.BeePants;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.utils.Utils;

public class WildFox extends MobDropTable {
    public WildFox() {
        super("WildFox", 14, 17, 20, 23, new Reward[]{
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(new Drumstick(100).getUpdatedItem(false), 5.0),
                new Reward(new Drumstick(50).getUpdatedItem(false), 25.0)
        });
    }
}
