package net.siegerpg.siege.core.crates.dropTables;


import net.siegerpg.siege.core.crates.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.epic.*;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.rare.*;

import java.util.HashMap;

public class SpiritDropTable extends CosmeticDropTable {

	public SpiritDropTable () {

		dropTable = new HashMap<>() {
			{
				//Rare
				put(new Antlers(0), 20);
				put(new AxeHead(0), 20);
				put(new Axolotl(0), 20);
				put(new Bedridden(0), 20);
				put(new BlueBetaBlob(0), 20);
				put(new Honey(0), 20);
				put(new Metroid(0), 20);
				put(new Panda(0), 20);
				put(new Pyromancer(0), 20);
				put(new TnT(0), 20);
				put(new Unirod(0), 20);

				//Epic
				put(new CarrotOnAStick(0), 10);
				put(new Crown(0), 10);
				put(new HotHead(0), 10);
				put(new Noteworthy(0), 10);
				put(new RedHeadphones(0), 10);
				put(new Spongebob(0), 10);
				put(new SquidHead(0), 10);
			}
		};
	}

}
