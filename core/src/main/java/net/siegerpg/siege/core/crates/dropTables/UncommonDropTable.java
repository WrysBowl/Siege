package net.siegerpg.siege.core.crates.dropTables;


import net.siegerpg.siege.core.crates.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.uncommon.*;

import java.util.HashMap;

public class UncommonDropTable extends CosmeticDropTable {
	public UncommonDropTable () {
		dropTable = new HashMap<>() {
			{
				put(new Bee(0), 10);
				put(new CrusaderHelmet(0), 10);
				put(new DavyJonesCap(0), 10);
				put(new GooBall(0), 10);
				put(new SlimeBlock(0), 10);
				put(new StoneFace(0), 10);
				put(new WiseGuy(0), 10);
				put(new WitchHat(0), 10);
			}
		};
	}
}
