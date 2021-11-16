package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.PolishedRegenerationGem;

public class PolishedRegeneration extends Fish {

	public PolishedRegeneration () {

		super(55, 1, 12, 18,
		      new PolishedRegenerationGem(0).getUpdatedItem(false)
		     );
	}

}
