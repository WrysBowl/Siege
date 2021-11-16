package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;

public class FlawedTough extends Fish {

	public FlawedTough () {

		super(45, 0.8, 16, 14,
		      new FlawedToughGem(0).getUpdatedItem(false));
	}

}
