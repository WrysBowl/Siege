package net.siegerpg.siege.core.crates.cosmetics.dropTables;


import net.siegerpg.siege.core.crates.cosmetics.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.common.*;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.uncommon.*;
import net.siegerpg.siege.core.items.implemented.misc.mounts.*;

import java.util.HashMap;

public class NormalDropTable extends CosmeticDropTable {

	public NormalDropTable() {

		dropTable = new HashMap<>() {
			{
				//Common
				//put(new AnonMask(), 20);
				//put(new ArrowHead(), 20);
				put(new BunnyEars(), 20);
				put(new Chocolate(), 20);
				put(new DogEars(), 20);
				put(new GrouchoGlasses(), 20);
				put(new Halo(), 20);
				put(new Mohawk(), 20);
				put(new PartyHat(), 20);
				put(new PigNose(), 20);
				//put(new SquidGame(), 20);
				put(new StrawHat(), 20);
				put(new SurgicalMask(), 20);
				put(new CowMount(), 15);
				put(new PigMount(), 15);
				put(new SheepMount(), 15);

				//Uncommon
				put(new Bee(), 10);
				put(new DavyJonesCap(), 10);
				//put(new GooBall(), 10);
				put(new SlimeBlock(), 10);
				put(new StoneFace(), 10);
				put(new WiseGuy(), 10);
				put(new WitchHat(), 10);
				put(new CatMount(), 15);
				put(new MooshroomMount(), 15);
				put(new SpiderMount(), 15);
				put(new LlamaMount(), 15);

			}
		};
	}

}
