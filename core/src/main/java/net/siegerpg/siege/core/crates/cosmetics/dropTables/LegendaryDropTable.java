package net.siegerpg.siege.core.crates.cosmetics.dropTables;


import net.siegerpg.siege.core.crates.cosmetics.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.legendary.*;
import net.siegerpg.siege.core.items.implemented.misc.mounts.*;

import java.util.HashMap;

public class LegendaryDropTable extends CosmeticDropTable {

	public LegendaryDropTable() {

		dropTable = new HashMap<>() {
			{
				put(new GlowSquid(0), 10);
				put(new HexShifter(0), 10);
				put(new Rainbow(0), 10);
				put(new Bandana(0), 10);
				put(new SilverTiara(0), 10);
				put(new LilUziDiamond(0), 10);
				put(new AxolotlMount(0), 15);
				put(new BeeMount(0), 15);
				put(new SkeletonHorseMount(0), 15);
			}
		};
	}

}
