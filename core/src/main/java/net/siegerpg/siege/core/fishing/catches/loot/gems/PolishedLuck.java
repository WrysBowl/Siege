package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PolishedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.PolishedRegenerationGem;

public class PolishedLuck extends Fish {

    public PolishedLuck(){
        super(55, 1, 12, 18,
                new PolishedLuckGem(0).getUpdatedItem(false));
    }
}
