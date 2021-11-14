package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.CrackedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.CrackedRegenerationGem;

public class CrackedLuck extends Fish {

    public CrackedLuck(){
        super(40, 0.7, 18, 12,
                new CrackedLuckGem(0).getUpdatedItem(false));
    }
}
