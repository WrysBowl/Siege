package net.siegerpg.siege.core.fishing.catches.loot;

import net.siegerpg.siege.core.fishing.catches.Fish;

public class Sugar extends Fish {

	public Sugar() {

		super(40, 0.8, 14, 10,
		      new net.siegerpg.siege.core.items.implemented.misc.food.Sugar().getUpdatedItem(false).asQuantity(16)
		     );
	}

}
