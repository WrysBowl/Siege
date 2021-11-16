package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;

public class FlawedStrength extends Fish {

	public FlawedStrength() {

		super(45, 0.8, 16, 14,
		      new FlawedStrengthGem(0).getUpdatedItem(false)
		     );
	}

}
