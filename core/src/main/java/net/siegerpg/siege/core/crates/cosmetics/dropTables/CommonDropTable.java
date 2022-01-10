package net.siegerpg.siege.core.crates.cosmetics.dropTables;


import net.siegerpg.siege.core.crates.cosmetics.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.common.*;

import java.util.HashMap;

public class CommonDropTable extends CosmeticDropTable {

	public CommonDropTable() {

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

				put(new BlueGlass(0), 40);
				put(new BlackGlass(0), 40);
				put(new BrownGlass(0), 40);
				put(new CyanGlass(0), 40);
				put(new GrayGlass(0), 40);
				put(new GreenGlass(0), 40);
				put(new LightBlueGlass(0), 40);
				put(new LightGrayGlass(0), 40);
				put(new LimeGlass(0), 40);
				put(new MagentaGlass(0), 40);
				put(new OrangeGlass(0), 40);
				put(new PinkGlass(0), 40);
				put(new PurpleGlass(0), 40);
				put(new RedGlass(0), 40);
				put(new WhiteGlass(0), 40);
				put(new YellowGlass(0), 40);
			}
		};
	}

}
