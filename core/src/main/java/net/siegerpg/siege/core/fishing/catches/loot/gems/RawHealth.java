package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.RawHealthGem;

public class RawHealth extends Fish {

	public RawHealth () {
		super(30, 0.6, 20, 10,
				new RawHealthGem(0).getUpdatedItem(false));
	}
}
