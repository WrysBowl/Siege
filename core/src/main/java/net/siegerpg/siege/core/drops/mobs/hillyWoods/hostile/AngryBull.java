package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.*;
import net.siegerpg.siege.core.utils.Utils;

public class AngryBull extends MobDropTable {
    public AngryBull() {
        super("AngryBull", 17, 20, 26, 29, new Reward[]{
                new Reward(Leather.Companion.tier(1).getUpdatedItem(false), 80.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 8.0),
                new Reward(Bone.Companion.tier(1).getUpdatedItem(false), 5.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 0.5),
                new Reward(new Beef(50).getUpdatedItem(false), 20.0),
                new Reward(new DullToughGem(Utils.randRarity()).getUpdatedItem(false), 0.25),
                new Reward(new FlawedHealthGem(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new DullHealthGem(Utils.randRarity()).getUpdatedItem(false), 0.25)
        });
    }
}
