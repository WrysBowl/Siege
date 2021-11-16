package net.siegerpg.siege.core.crates.dropTables;


import net.siegerpg.siege.core.crates.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.common.*;

import java.util.HashMap;

public class CommonDropTable extends CosmeticDropTable {
	public CommonDropTable () {
		dropTable = new HashMap<>() {
			{
				put(new AnonMask(0), 10);
				put(new ArrowHead(0), 10);
				put(new BunnyEars(0), 10);
				put(new Chocolate(0), 10);
				put(new DogEars(0), 10);
				put(new GrouchoGlasses(0), 10);
				put(new Halo(0), 10);
				put(new Mohawk(0), 10);
				put(new PartyHat(0), 10);
				put(new PigNose(0), 10);
				put(new SquidGame(0), 10);
				put(new StrawHat(0), 10);
				put(new SurgicalMask(0), 10);
			}
		};
	}
}
