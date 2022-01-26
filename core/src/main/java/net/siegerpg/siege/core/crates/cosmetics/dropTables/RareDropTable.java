package net.siegerpg.siege.core.crates.cosmetics.dropTables;


import net.siegerpg.siege.core.crates.cosmetics.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.rare.*;
import net.siegerpg.siege.core.items.implemented.misc.mounts.*;

import java.util.HashMap;

public class RareDropTable extends CosmeticDropTable {

	public RareDropTable() {

		dropTable = new HashMap<>() {
			{
				put(new Antlers(), 10);
				put(new AxeHead(), 10);
				put(new Axolotl(), 10);
				put(new BlueBetaBlob(), 10);
				put(new Metroid(), 10);
				put(new Panda(), 10);
				put(new Pyromancer(), 10);
				put(new DonkeyMount(), 15);
				put(new FoxMount(), 15);
				put(new HorseMount(), 15);
				put(new PolarBearMount(), 15);
				put(new HorseMount(), 15);

				put(new TnT(), 20);
				put(new Unirod(), 20);
				put(new Honey(), 20);
				put(new BlueBedridden(), 20);
				put(new RedBedridden(), 20);
				put(new YellowBedridden(), 20);
				put(new GreenBedridden(), 20);
				put(new BrainCoral(), 20);
				put(new BubbleCoral(), 20);
				put(new CoalBlock(), 20);
				put(new IronBlock(), 20);
				put(new GoldBlock(), 20);
				put(new DiamondBlock(), 20);
				put(new LapisBlock(), 20);
				put(new RedstoneBlock(), 20);
				put(new EmeraldBlock(), 20);
				put(new Dispenser(), 20);
				put(new FireCoral(), 20);
				put(new RespawnAnchor(), 20);
				put(new Honeycomb(), 20);
				put(new TubeCoral(), 20);
			}
		};
	}

}
