package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;

public class FlawedRegeneration extends Fish {

	public FlawedRegeneration () {

		super(45, 0.8, 16, 14,
		      new FlawedRegenerationGem(0).getUpdatedItem(false)
		     );
	}

}
