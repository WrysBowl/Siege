package net.siegerpg.siege.core.crates.cosmetics.dropTables;


import net.siegerpg.siege.core.crates.cosmetics.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.epic.*;
import net.siegerpg.siege.core.items.implemented.misc.mounts.*;

import java.util.HashMap;

public class EpicDropTable extends CosmeticDropTable {

	public EpicDropTable() {

		dropTable = new HashMap<>() {
			{
				put(new CarrotOnAStick(), 10);
				put(new Crown(), 10);
				put(new HotHead(), 10);
				put(new Headphones(), 10);
				put(new SquidHead(), 10);
				put(new GoatMount(), 15);
				put(new HoglinMount(), 15);
				put(new PandaMount(), 15);

				put(new Noteworthy(), 10);
				put(new Spongebob(), 10);
				put(new AncientDebris(), 20);
				put(new WhiteGlaze(), 20);
				put(new OrangeGlaze(), 20);
				put(new PurpleGlaze(), 20);
				put(new RedGlaze(), 20);
				put(new BlackGlaze(), 20);
				put(new BlueGlaze(), 20);
				put(new LightBlueGlaze(), 20);
				put(new GrayGlaze(), 20);
				put(new BrownGlaze(), 20);
				put(new YellowGlaze(), 20);
				put(new GreenGlaze(), 20);
				put(new LimeGlaze(), 20);
				put(new MagentaGlaze(), 20);
				put(new PinkGlaze(), 20);
				put(new CyanGlaze(), 20);
				put(new MagmaBlock(), 20);
				put(new Cactus(), 20);
				put(new Bedrock(), 20);
				put(new BeeNest(), 20);
				put(new Shroomlight(), 20);
				put(new CryingObsidian(), 20);

			}
		};
	}

}
