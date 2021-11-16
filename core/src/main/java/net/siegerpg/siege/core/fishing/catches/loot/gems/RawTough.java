package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.RawToughGem;

public class RawTough extends Fish {

	public RawTough() {

		super(30, 0.6, 20, 10,
		      new RawToughGem(0).getUpdatedItem(false)
		     );
	}

}
