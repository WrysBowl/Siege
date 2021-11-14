package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.FlawedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.RawHealthGem;

public class FlawedHealth extends Fish {

    public FlawedHealth(){
        super(45, 0.8, 16, 14,
                new FlawedHealthGem(0).getUpdatedItem(false));
    }
}
