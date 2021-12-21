package net.siegerpg.siege.core.crates.cosmetics.dropTables;


import net.siegerpg.siege.core.crates.cosmetics.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.epic.*;

import java.util.HashMap;

public class EpicDropTable extends CosmeticDropTable {

	public EpicDropTable() {

		dropTable = new HashMap<>() {
			{
				put(new CarrotOnAStick(0), 10);
				put(new Crown(0), 10);
				put(new HotHead(0), 10);
				put(new Headphones(0), 10);
				put(new SquidHead(0), 10);

				put(new Noteworthy(0), 10);
				put(new Spongebob(0), 10);
				put(new AncientDebris(0), 20);
				put(new WhiteGlaze(0), 20);
				put(new OrangeGlaze(0), 20);
				put(new PurpleGlaze(0), 20);
				put(new RedGlaze(0), 20);
				put(new BlackGlaze(0), 20);
				put(new BlueGlaze(0), 20);
				put(new LightBlueGlaze(0), 20);
				put(new GrayGlaze(0), 20);
				put(new BrownGlaze(0), 20);
				put(new YellowGlaze(0), 20);
				put(new GreenGlaze(0), 20);
				put(new LimeGlaze(0), 20);
				put(new MagentaGlaze(0), 20);
				put(new PinkGlaze(0), 20);
				put(new CyanGlaze(0), 20);
				put(new MagmaBlock(0), 20);
				put(new Cactus(0), 20);
				put(new Bedrock(0), 20);
				put(new BeeNest(0), 20);
				put(new Shroomlight(0), 20);
				put(new CryingObsidian(0), 20);

			}
		};
	}

}
