package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.WerewolfKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.utils.Utils;

public class Werewolf extends MobDropTable {
    public Werewolf() {
        super("Werewolf", 600, 700, 1550, 1600, new Reward[]{
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 50.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 40.0),
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false).asQuantity(16), 30.0),
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false).asQuantity(16), 30.0),
                new Reward(new FemurBone(Utils.randRarity()).getUpdatedItem(false), 50.0),
                new Reward(new FemurBone(Utils.randRarity()).getUpdatedItem(false), 25.0),
                new Reward(new WerewolfKey(0).getUpdatedItem(false), 10.0)

        });
    }
}