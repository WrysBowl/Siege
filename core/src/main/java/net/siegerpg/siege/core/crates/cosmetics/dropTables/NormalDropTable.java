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
				//put(new AnonMask(0), 20);
				//put(new ArrowHead(0), 20);
				//put(new BunnyEars(0), 20);
				put(new Chocolate(0), 20);
				put(new DogEars(0), 20);
				//put(new GrouchoGlasses(0), 20);
				//put(new Halo(0), 20);
				put(new Mohawk(0), 20);
				//put(new PartyHat(0), 20);
				//put(new PigNose(0), 20);
				//put(new SquidGame(0), 20);
				put(new StrawHat(0), 20);
				put(new SurgicalMask(0), 20);
				put(new CowMount(0), 15);
				put(new PigMount(0), 15);
				put(new SheepMount(0), 15);

				//Uncommon
				put(new Bee(0), 10);
				put(new CrusaderHelmet(0), 10);
				put(new DavyJonesCap(0), 10);
				put(new GooBall(0), 10);
				put(new SlimeBlock(0), 10);
				put(new StoneFace(0), 10);
				put(new WiseGuy(0), 10);
				put(new WitchHat(0), 10);
				put(new CatMount(0), 15);
				put(new MooshroomMount(0), 15);
				put(new SpiderMount(0), 15);
				put(new LlamaMount(0), 15);

			}
		};
	}

}
