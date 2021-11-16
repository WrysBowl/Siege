package net.siegerpg.siege.core.crates.dropTables;


import net.siegerpg.siege.core.crates.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.legendary.GlowSquid;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.legendary.HexShifter;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.legendary.Rainbow;

import java.util.HashMap;

public class LegendaryDropTable extends CosmeticDropTable {

	public LegendaryDropTable () {

		dropTable = new HashMap<>() {
			{
				put(new GlowSquid(0), 10);
				put(new HexShifter(0), 10);
				put(new Rainbow(0), 10);
			}
		};
	}

}
