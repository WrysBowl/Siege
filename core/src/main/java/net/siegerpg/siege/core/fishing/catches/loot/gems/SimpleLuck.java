package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;

public class SimpleLuck extends Fish {

	public SimpleLuck() {

		super(50, 0.9, 14, 16,
		      new SimpleLuckGem(0).getUpdatedItem(false)
		     );
	}

}
