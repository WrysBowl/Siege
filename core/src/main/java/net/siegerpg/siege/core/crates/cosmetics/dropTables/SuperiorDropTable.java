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
				put(new Bee(0), 20);
				//put(new CrusaderHelmet(0), 20);
				put(new DavyJonesCap(0), 20);
				//put(new GooBall(0), 20);
				put(new SlimeBlock(0), 20);
				put(new StoneFace(0), 20);
				put(new WiseGuy(0), 20);
				put(new WitchHat(0), 20);
				put(new CatMount(0), 15);
				put(new MooshroomMount(0), 15);
				put(new SpiderMount(0), 15);
				put(new LlamaMount(0), 15);

				//Rare
				put(new Antlers(0), 10);
				//put(new AxeHead(0), 10);
				//put(new Axolotl(0), 10);
				//put(new BlueBetaBlob(0), 10);
				put(new Honey(0), 10);
				//put(new Metroid(0), 10);
				put(new Panda(0), 10);
				//put(new Pyromancer(0), 10);
				put(new TnT(0), 10);
				put(new Unirod(0), 10);
				put(new FoxMount(0), 15);
				put(new HorseMount(0), 15);
				put(new PolarBearMount(0), 15);
				put(new HorseMount(0), 15);
			}
		};
	}

}
