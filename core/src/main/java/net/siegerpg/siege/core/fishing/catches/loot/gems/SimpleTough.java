package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;

public class SimpleTough extends Fish {

	public SimpleTough () {

		super(50, 0.9, 14, 16,
		      new SimpleToughGem(0).getUpdatedItem(false));
	}

}
