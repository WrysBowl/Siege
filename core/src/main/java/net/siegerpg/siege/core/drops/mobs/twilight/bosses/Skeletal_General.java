package net.siegerpg.siege.core.drops.mobs.twilight.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.TwilightDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PolishedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PolishedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;


public class Skeletal_General extends MobDropTable {
    public Skeletal_General() {
        super("Skeletal_General", 200, 300, 250, 300, new Reward[]{
                new Reward(CorruptCrystal.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 70.0),
                new Reward(CorruptCrystal.Companion.tier(3).getUpdatedItem(false), 30.0),
                new Reward(CursedBone.Companion.tier(2).getUpdatedItem(false).asQuantity(4), 70.0),
                new Reward(CursedBone.Companion.tier(3).getUpdatedItem(false), 30.0),

                new Reward(new PolishedToughGem(0).getUpdatedItem(false), 10.0),
                new Reward(new PolishedStrengthGem(0).getUpdatedItem(false), 10.0),
                new Reward(new TwilightDungeonKey(0).getUpdatedItem(false), 10.0)
        });
    }
}
