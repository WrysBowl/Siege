package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.RawLuckGem;

public class RawLuck extends Fish {

	public RawLuck() {

		super(30, 0.6, 20, 10,
		      new RawLuckGem(0).getUpdatedItem(false)
		     );
	}

}
