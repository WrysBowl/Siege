package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.CrackedHealthGem;

public class CrackedHealth extends Fish {

	public CrackedHealth () {

		super(40, 0.7, 18, 12,
		      new CrackedHealthGem(0).getUpdatedItem(false));
	}

}
