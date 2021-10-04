package net.siegerpg.siege.core.drops.mobs.twilight.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.SparklingLeaves;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;


public class Stone_Monster extends MobDropTable {
    public Stone_Monster() {
        super("Stone_Monster", 35, 45, 45, 55, new Reward[]{
                new Reward(Pebble.Companion.tier(2).getUpdatedItem(false), 25.0),
                new Reward(Pebble.Companion.tier(3).getUpdatedItem(false), 5.0),
                new Reward(FairyDust.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(FairyDust.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(PlantMatter.Companion.tier(2).getUpdatedItem(false), 50.0),

                new Reward(new FlawedStrengthGem(0).getUpdatedItem(false), 1.0),
                new Reward(new SimpleToughGem(0).getUpdatedItem(false), 0.5),
        });
    }
}
