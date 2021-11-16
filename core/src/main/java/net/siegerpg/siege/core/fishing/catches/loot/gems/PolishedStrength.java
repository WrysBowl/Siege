package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PolishedStrengthGem;

public class PolishedStrength extends Fish {

	public PolishedStrength () {

		super(55, 1, 12, 18,
		      new PolishedStrengthGem(0).getUpdatedItem(false)
		     );
	}

}
