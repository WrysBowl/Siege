package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.CrackedStrengthGem;

public class CrackedStrength extends Fish {

	public CrackedStrength () {

		super(40, 0.7, 18, 12,
		      new CrackedStrengthGem(0).getUpdatedItem(false));
	}

}
