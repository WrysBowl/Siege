package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PristineLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.PristineRegenerationGem;

public class PristineRegeneration extends Fish {

    public PristineRegeneration(){
        super(60, 1, 12, 20,
                new PristineRegenerationGem(0).getUpdatedItem(false));
    }
}
