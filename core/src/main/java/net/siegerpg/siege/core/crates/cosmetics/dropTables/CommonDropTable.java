package net.siegerpg.siege.core.crates.cosmetics.dropTables;


import net.siegerpg.siege.core.crates.cosmetics.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.common.*;
import net.siegerpg.siege.core.items.implemented.misc.mounts.CowMount;
import net.siegerpg.siege.core.items.implemented.misc.mounts.PigMount;
import net.siegerpg.siege.core.items.implemented.misc.mounts.SheepMount;

import java.util.HashMap;

public class CommonDropTable extends CosmeticDropTable {

	public CommonDropTable() {

		dropTable = new HashMap<>() {
			{
				put(new AnonMask(), 10);
				put(new ArrowHead(), 10);
				put(new BunnyEars(), 10);
				put(new Chocolate(), 10);
				put(new DogEars(), 10);
				put(new GrouchoGlasses(), 10);
				put(new Halo(), 10);
				put(new Mohawk(), 10);
				put(new PartyHat(), 10);
				put(new PigNose(), 10);
				put(new SquidGame(), 10);
				put(new StrawHat(), 10);
				put(new SurgicalMask(), 10);
				put(new CowMount(), 15);
				put(new PigMount(), 15);
				put(new SheepMount(), 15);

				put(new BlueGlass(), 40);
				put(new BlackGlass(), 40);
				put(new BrownGlass(), 40);
				put(new CyanGlass(), 40);
				put(new GrayGlass(), 40);
				put(new GreenGlass(), 40);
				put(new LightBlueGlass(), 40);
				put(new LightGrayGlass(), 40);
				put(new LimeGlass(), 40);
				put(new MagentaGlass(), 40);
				put(new OrangeGlass(), 40);
				put(new PinkGlass(), 40);
				put(new PurpleGlass(), 40);
				put(new RedGlass(), 40);
				put(new WhiteGlass(), 40);
				put(new YellowGlass(), 40);
			}
		};
	}

}
