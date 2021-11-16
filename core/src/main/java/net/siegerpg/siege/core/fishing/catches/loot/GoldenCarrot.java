package net.siegerpg.siege.core.fishing.catches.loot;

import net.siegerpg.siege.core.fishing.catches.Fish;

public class GoldenCarrot extends Fish {

	public GoldenCarrot () {

		super(15, 1, 28, 8,
		      new net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot(0).getUpdatedItem(false));
	}

}
