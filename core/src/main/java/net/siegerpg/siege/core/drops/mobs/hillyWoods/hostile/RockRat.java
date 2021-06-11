package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.CrackedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.DullStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.CrackedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.utils.Utils;

public class RockRat extends MobDropTable {
    public RockRat() {
        super("RockRat", 3, 5, 2, 4, new Reward[]{
                new Reward(Pebble.Companion.tier(1).getUpdatedItem(false), 100.0),
                new Reward(Pebble.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(new RockWand(Utils.randRarity()).getUpdatedItem(false), 0.01),
                new Reward(new CrackedStrengthGem(Utils.randRarity()).getUpdatedItem(false), 2.0),
                new Reward(new CrackedToughGem(Utils.randRarity()).getUpdatedItem(false), 2.0)
        });
    }
}
