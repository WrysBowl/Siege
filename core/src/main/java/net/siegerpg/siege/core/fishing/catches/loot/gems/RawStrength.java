package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.RawStrengthGem;

public class RawStrength extends Fish {

	public RawStrength () {

		super(30, 0.6, 20, 10,
		      new RawStrengthGem(0).getUpdatedItem(false)
		     );
	}

}
