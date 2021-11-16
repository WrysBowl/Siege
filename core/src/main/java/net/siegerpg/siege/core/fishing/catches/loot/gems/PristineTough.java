package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PristineToughGem;

public class PristineTough extends Fish {

	public PristineTough () {

		super(60, 1, 12, 20,
		      new PristineToughGem(0).getUpdatedItem(false));
	}

}
