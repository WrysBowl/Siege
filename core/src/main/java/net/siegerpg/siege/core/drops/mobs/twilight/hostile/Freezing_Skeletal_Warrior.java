package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.TwilightDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.IceShard;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PolishedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;


public class Freezing_Skeletal_Warrior extends MobDropTable {
    public Freezing_Skeletal_Warrior() {
        super("Freezing_Skeletal_Warrior", 80, 90, 110, 120, new Reward[]{
                new Reward(CorruptCrystal.Companion.tier(1).getUpdatedItem(false), 30.0),
                new Reward(CorruptCrystal.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(CursedBone.Companion.tier(1).getUpdatedItem(false), 30.0),
                new Reward(CursedBone.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(Ectoplasm.Companion.tier(1).getUpdatedItem(false).asQuantity(3), 50.0),
                new Reward(Ectoplasm.Companion.tier(2).getUpdatedItem(false), 15.0),
                new Reward(IceShard.Companion.tier(1).getUpdatedItem(false).asQuantity(4), 30.0),
                new Reward(IceShard.Companion.tier(2).getUpdatedItem(false), 10.0),

                new Reward(new PolishedToughGem(0).getUpdatedItem(false), 0.5),
                new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 1.0),
                new Reward(new TwilightDungeonKey(0).getUpdatedItem(false), 2.0)
        });
    }
}
