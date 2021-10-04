package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Beetroot;
import net.siegerpg.siege.core.items.implemented.misc.food.SusStew;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyWing;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.CrackedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.RawRegenerationGem;
import net.siegerpg.siege.core.utils.Utils;


public class Fairy_Outlaw extends MobDropTable {
    public Fairy_Outlaw() {
        super("Fairy_Outlaw", 30, 50, 40, 60, new Reward[]{
                new Reward(FairyDust.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(FairyDust.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(FairyWing.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(FairyWing.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 25.0),

                new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 1.0),
                new Reward(new FlawedRegenerationGem(0).getUpdatedItem(false), 1.0),
        });
    }
}
