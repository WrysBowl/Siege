package net.siegerpg.siege.core.fishing.catches.loot;

import net.siegerpg.siege.core.fishing.catches.Fish;

public class SusStew extends Fish {

	public SusStew() {

		super(25, 0.5, 24, 12,
		      new net.siegerpg.siege.core.items.implemented.misc.food.SusStew(0).getUpdatedItem(
				      false)
		     );
	}

}
