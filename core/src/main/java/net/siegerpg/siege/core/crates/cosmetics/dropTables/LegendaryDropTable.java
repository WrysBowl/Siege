package net.siegerpg.siege.core.crates.cosmetics.dropTables;


import net.siegerpg.siege.core.crates.cosmetics.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.legendary.*;
import net.siegerpg.siege.core.items.implemented.misc.mounts.*;

import java.util.HashMap;

public class LegendaryDropTable extends CosmeticDropTable {

	public LegendaryDropTable() {

		dropTable = new HashMap<>() {
			{
				put(new GlowSquid(), 10);
				put(new HexShifter(), 10);
				put(new Rainbow(), 10);
				put(new LilUziDiamond(), 10);
				put(new AxolotlMount(), 15);
				put(new BeeMount(), 15);
				put(new SkeletonHorseMount(), 15);
			}
		};
	}

}
