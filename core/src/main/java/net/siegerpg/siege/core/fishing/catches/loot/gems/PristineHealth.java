package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.PristineHealthGem;

public class PristineHealth extends Fish {

	public PristineHealth () {

		super(60, 1, 12, 20,
		      new PristineHealthGem(0).getUpdatedItem(false)
		     );
	}

}
