package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PolishedToughGem;

public class PolishedTough extends Fish {

	public PolishedTough () {

		super(55, 1, 12, 18,
		      new PolishedToughGem(0).getUpdatedItem(false)
		     );
	}

}
