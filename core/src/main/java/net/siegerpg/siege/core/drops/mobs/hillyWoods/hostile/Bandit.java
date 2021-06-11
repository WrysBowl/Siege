package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Dagger;
import net.siegerpg.siege.core.utils.Utils;

public class Bandit extends MobDropTable {
    public Bandit() {
        super("Bandit", 25, 28, 45, 48, new Reward[]{
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 2.5),
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 15.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 1.5),
                new Reward(MetalScrap.Companion.tier(1).getUpdatedItem(false), 7.5),
                new Reward(new Dagger(Utils.randRarity()).getUpdatedItem(false), 4.0)
        });
    }
}
