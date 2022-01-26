package net.siegerpg.siege.core.crates.cosmetics.dropTables;


import net.siegerpg.siege.core.crates.cosmetics.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.epic.*;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.rare.*;
import net.siegerpg.siege.core.items.implemented.misc.mounts.*;

import java.util.HashMap;

public class SpiritDropTable extends CosmeticDropTable {

	public SpiritDropTable() {

		dropTable = new HashMap<>() {
			{
				//Rare
				put(new Antlers(), 20);
				//put(new AxeHead(), 20);
				//put(new Axolotl(), 20);
				//put(new BlueBetaBlob(), 20);
				put(new Honey(), 20);
				put(new Metroid(), 20);
				put(new Panda(), 20);
				//put(new Pyromancer(), 20);
				put(new TnT(), 20);
				put(new Unirod(), 20);
				put(new FoxMount(), 15);
				put(new HorseMount(), 15);
				put(new PolarBearMount(), 15);
				put(new HorseMount(), 15);

				//Epic
				put(new CarrotOnAStick(), 10);
				put(new Crown(), 10);
				put(new HotHead(), 10);
				put(new Noteworthy(), 10);
				put(new Headphones(), 10);
				put(new Spongebob(), 10);
				put(new SquidHead(), 10);
				put(new GoatMount(), 15);
				put(new HoglinMount(), 15);
				put(new PandaMount(), 15);
			}
		};
	}

}
