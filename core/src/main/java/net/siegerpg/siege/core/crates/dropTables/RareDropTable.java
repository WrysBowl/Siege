package net.siegerpg.siege.core.crates.dropTables;


import net.siegerpg.siege.core.crates.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.rare.*;

import java.util.HashMap;

public class RareDropTable extends CosmeticDropTable {
	public RareDropTable () {
		dropTable = new HashMap<>() {
			{
				put(new Antlers(0), 10);
				put(new AxeHead(0), 10);
				put(new Axolotl(0), 10);
				put(new Bedridden(0), 10);
				put(new BlueBetaBlob(0), 10);
				put(new Honey(0), 10);
				put(new Metroid(0), 10);
				put(new Panda(0), 10);
				put(new Pyromancer(0), 10);
				put(new TnT(0), 10);
				put(new Unirod(0), 10);
			}
		};
	}
}
