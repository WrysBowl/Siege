package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;

public class SimpleHealth extends Fish {

	public SimpleHealth () {

		super(50, 0.9, 14, 16,
		      new SimpleHealthGem(0).getUpdatedItem(false));
	}

}
