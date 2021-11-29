package net.siegerpg.siege.core.crates.dropTables;


import net.siegerpg.siege.core.crates.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.rare.*;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.uncommon.*;

import java.util.HashMap;

public class SuperiorDropTable extends CosmeticDropTable {

	public SuperiorDropTable() {

		dropTable = new HashMap<>() {
			{
				//Uncommon
				put(new Bee(0), 20);
				put(new CrusaderHelmet(0), 20);
				put(new DavyJonesCap(0), 20);
				put(new GooBall(0), 20);
				put(new SlimeBlock(0), 20);
				put(new StoneFace(0), 20);
				put(new WiseGuy(0), 20);
				put(new WitchHat(0), 20);

				//Rare
				put(new Antlers(0), 10);
				put(new AxeHead(0), 10);
				put(new Axolotl(0), 10);
				put(new RedBedridden(0), 10);
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
