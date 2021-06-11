package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.utils.Utils;

public class BloodSucker extends MobDropTable {
    public BloodSucker() {
        super("BloodSucker", 13, 16, 19, 22, new Reward[]{
                new Reward(Vine.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(Vine.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(Seed.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(Seed.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(new SusStew(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new CrackedRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 1.0),
                new Reward(new DullRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 0.5),
                new Reward(new CrackedLuckGem(Utils.randRarity()).getUpdatedItem(false), 1.0)
        });
    }
}
