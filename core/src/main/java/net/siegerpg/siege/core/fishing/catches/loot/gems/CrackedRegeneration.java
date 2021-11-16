package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.CrackedRegenerationGem;

public class CrackedRegeneration extends Fish {

	public CrackedRegeneration() {

		super(40, 0.7, 18, 12,
		      new CrackedRegenerationGem(0).getUpdatedItem(false)
		     );
	}

}
