package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;

public class FlawedLuck extends Fish {

	public FlawedLuck() {

		super(45, 0.8, 16, 14,
		      new FlawedLuckGem(0).getUpdatedItem(false)
		     );
	}

}
