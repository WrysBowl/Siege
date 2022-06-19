package net.siegerpg.siege.core.crates.cosmetics.dropTables;


import net.siegerpg.siege.core.crates.cosmetics.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.rare.*;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.uncommon.*;
import net.siegerpg.siege.core.items.implemented.misc.mounts.*;

import java.util.HashMap;

public class SuperiorDropTable extends CosmeticDropTable {

	public SuperiorDropTable() {

		dropTable = new HashMap<>() {
			{
				//Uncommon
				put(new Bee(), 20);
				put(new DavyJonesCap(), 20);
				put(new GooBall(), 20);
				put(new SlimeBlock(), 20);
				put(new StoneFace(), 20);
				put(new WiseGuy(), 20);
				put(new WitchHat(), 20);
				put(new CatMount(), 15);
				put(new MooshroomMount(), 15);
				put(new SpiderMount(), 15);
				put(new LlamaMount(), 15);

				//Rare
				put(new Antlers(), 10);
				put(new AxeHead(), 10);
				put(new Axolotl(), 10);
				put(new BlueBetaBlob(), 10);
				put(new Honey(), 10);
				put(new Metroid(), 10);
				put(new Panda(), 10);
				put(new Pyromancer(), 10);
				put(new TnT(), 10);
				put(new Unirod(), 10);
				put(new FoxMount(), 15);
				put(new HorseMount(), 15);
				put(new PolarBearMount(), 15);
				put(new HorseMount(), 15);
			}
		};
	}

}
