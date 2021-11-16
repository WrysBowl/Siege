package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PristineLuckGem;

public class PristineLuck extends Fish {

	public PristineLuck() {

		super(60, 1, 12, 20,
		      new PristineLuckGem(0).getUpdatedItem(false)
		     );
	}

}
