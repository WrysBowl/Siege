package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.TwilightDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyWing;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;


public class Dark_Fairy extends MobDropTable {
    public Dark_Fairy() {
        super("Dark_Fairy", 50, 60, 50, 60, new Reward[]{
                new Reward(FairyDust.Companion.tier(1).getUpdatedItem(false), 25.0),
                new Reward(FairyDust.Companion.tier(2).getUpdatedItem(false), 5.0),
                new Reward(FairyWing.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(FairyWing.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(CorruptCrystal.Companion.tier(1).getUpdatedItem(false), 25.0),

                new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 0.5),
                new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 0.5),
                new Reward(new TwilightDungeonKey(0).getUpdatedItem(false), 1.0)
        });
    }
}
