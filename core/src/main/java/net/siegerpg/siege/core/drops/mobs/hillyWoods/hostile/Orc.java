package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.CrackedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.CrackedToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.utils.Utils;

public class Orc extends MobDropTable {
    public Orc() {
        super("Orc", 15, 19, 20, 24, new Reward[]{
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 60.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 6.0),
                new Reward(new GiantClub(Utils.randRarity()).getUpdatedItem(false), 25.0),
                new Reward(new SusStew(Utils.randRarity()).getUpdatedItem(false), 35.0),
                new Reward(new SimpleStrengthGem(Utils.randRarity()).getUpdatedItem(false), 0.5),
                new Reward(new CrackedStrengthGem(Utils.randRarity()).getUpdatedItem(false), 2.0),
                new Reward(new CrackedToughGem(Utils.randRarity()).getUpdatedItem(false), 2.0)
        });
    }
}
