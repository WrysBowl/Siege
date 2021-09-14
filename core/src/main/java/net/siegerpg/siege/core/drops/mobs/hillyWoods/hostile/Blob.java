package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.HillyWoodsDungeonKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.*;

public class Blob extends MobDropTable {
    public Blob() {
        super("Blob", 7, 10, 7, 10, new Reward[]{
                new Reward(Slime.Companion.tier(1).getUpdatedItem(false), 100.0),
                new Reward(Slime.Companion.tier(2).getUpdatedItem(false), 10.0),
                new Reward(new RawRegenerationGem(0).getUpdatedItem(false), 1.0),
                new Reward(new RawLuckGem(0).getUpdatedItem(false), 1.0),
        });
    }
}
