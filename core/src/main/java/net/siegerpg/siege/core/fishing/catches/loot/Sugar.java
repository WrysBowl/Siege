package net.siegerpg.siege.core.fishing.catches.loot;

import net.siegerpg.siege.core.fishing.catches.Fish;

public class Sugar extends Fish {

    public Sugar(){
        super(15, 1, 18, 6,
                new net.siegerpg.siege.core.items.implemented.misc.food.Sugar(0).getUpdatedItem(false));
    }
}
