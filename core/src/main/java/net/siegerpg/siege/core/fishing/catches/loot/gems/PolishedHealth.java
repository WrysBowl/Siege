package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.PolishedHealthGem;

public class PolishedHealth extends Fish {

	public PolishedHealth () {

		super(55, 1, 12, 18,
		      new PolishedHealthGem(0).getUpdatedItem(false)
		     );
	}

}
