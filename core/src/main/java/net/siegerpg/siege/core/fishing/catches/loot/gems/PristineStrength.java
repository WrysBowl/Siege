package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PristineStrengthGem;

public class PristineStrength extends Fish {

	public PristineStrength () {

		super(60, 1, 12, 20,
		      new PristineStrengthGem(0).getUpdatedItem(false));
	}

}
