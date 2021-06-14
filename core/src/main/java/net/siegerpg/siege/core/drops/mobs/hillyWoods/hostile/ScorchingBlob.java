package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.CrackedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.CrackedStrengthGem;
import net.siegerpg.siege.core.utils.Utils;

public class ScorchingBlob extends MobDropTable {
    public ScorchingBlob() {
        super("ScorchingBlob", 6, 9, 11, 14, new Reward[]{
                new Reward(Magma.Companion.tier(1).getUpdatedItem(false), 100.0),
                new Reward(Magma.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(new CrackedStrengthGem(Utils.randRarity()).getUpdatedItem(false), 2.0),
                new Reward(new CrackedRegenerationGem(Utils.randRarity()).getUpdatedItem(false), 2.0)
        });
    }
}
