package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;


public class InfectedDigger extends MobDropTable {
    public InfectedDigger() {
        super("InfectedDigger", 18, 22, 24, 27, new Reward[]{
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 80.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 8.0),
                new Reward(new Beetroot(50).getUpdatedItem(false), 10.0),
                new Reward(new Beetroot(0).getUpdatedItem(false), 50.0),
                new Reward(new SusStew(Utils.randRarity()).getUpdatedItem(false), 5.0)
        });
    }
}
