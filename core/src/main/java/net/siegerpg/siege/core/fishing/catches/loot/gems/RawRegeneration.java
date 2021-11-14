package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.RawHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.RawRegenerationGem;

public class RawRegeneration extends Fish {

    public RawRegeneration(){
        super(30, 0.6, 20, 10,
                new RawRegenerationGem(0).getUpdatedItem(false));
    }
}
