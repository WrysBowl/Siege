package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;

public class SimpleRegeneration extends Fish {

	public SimpleRegeneration () {

		super(50, 0.9, 14, 16,
		      new SimpleRegenerationGem(0).getUpdatedItem(false));
	}

}
