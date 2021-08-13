package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.TwilightDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;


public class Skeletal_Archer extends MobDropTable {
    public Skeletal_Archer() {
        super("Skeletal_Bowman", 40, 50, 50, 60, new Reward[]{
                new Reward(CorruptCrystal.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(CorruptCrystal.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(CursedBone.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(CursedBone.Companion.tier(2).getUpdatedItem(false), 10.0),

                new Reward(new FlawedToughGem(0).getUpdatedItem(false), 1.0),
                new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 0.5),
                new Reward(new TwilightDungeonKey(0).getUpdatedItem(false), 1.0)
        });
    }
}
