package net.siegerpg.siege.core.fishing.catches.loot.gems;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.CrackedToughGem;

public class CrackedTough extends Fish {

	public CrackedTough () {
		super(40, 0.7, 18, 12,
				new CrackedToughGem(0).getUpdatedItem(false));
	}
}
