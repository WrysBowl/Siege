package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.HillyWoodsDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.RawRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.RawStrengthGem;

public class ScorchingBlob extends MobDropTable {
    public ScorchingBlob() {
        super("ScorchingBlob", 6, 9, 11, 14, new Reward[]{
                new Reward(Magma.Companion.tier(1).getUpdatedItem(false), 100.0),
                new Reward(Magma.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(new RawStrengthGem(0).getUpdatedItem(false), 2.0),
                new Reward(new RawRegenerationGem(0).getUpdatedItem(false), 2.0),
        });
    }
}
