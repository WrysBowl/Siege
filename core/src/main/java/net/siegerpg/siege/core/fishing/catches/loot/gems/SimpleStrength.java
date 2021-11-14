package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;

public class SimpleStrength extends Fish {

    public SimpleStrength(){
        super(50, 0.9, 14, 16,
                new SimpleStrengthGem(0).getUpdatedItem(false));
    }
}
