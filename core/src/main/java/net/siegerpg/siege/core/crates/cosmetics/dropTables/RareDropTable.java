package net.siegerpg.siege.core.crates.cosmetics.dropTables;


import net.siegerpg.siege.core.crates.cosmetics.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.rare.*;
import net.siegerpg.siege.core.items.implemented.misc.mounts.*;

import java.util.HashMap;

public class RareDropTable extends CosmeticDropTable {

	public RareDropTable() {

		dropTable = new HashMap<>() {
			{
				put(new Antlers(0), 10);
				put(new AxeHead(0), 10);
				put(new Axolotl(0), 10);
				put(new BlueBetaBlob(0), 10);
				put(new Metroid(0), 10);
				put(new Panda(0), 10);
				put(new Pyromancer(0), 10);
				put(new DonkeyMount(0), 15);
				put(new FoxMount(0), 15);
				put(new HorseMount(0), 15);
				put(new PolarBearMount(0), 15);
				put(new HorseMount(0), 15);

				put(new TnT(0), 20);
				put(new Unirod(0), 20);
				put(new Honey(0), 20);
				put(new BlueBedridden(0), 20);
				put(new RedBedridden(0), 20);
				put(new YellowBedridden(0), 20);
				put(new GreenBedridden(0), 20);
				put(new BrainCoral(0), 20);
				put(new BubbleCoral(0), 20);
				put(new CoalBlock(0), 20);
				put(new IronBlock(0), 20);
				put(new GoldBlock(0), 20);
				put(new DiamondBlock(0), 20);
				put(new LapisBlock(0), 20);
				put(new RedstoneBlock(0), 20);
				put(new EmeraldBlock(0), 20);
				put(new Dispenser(0), 20);
				put(new FireCoral(0), 20);
				put(new RespawnAnchor(0), 20);
				put(new Honeycomb(0), 20);
				put(new TubeCoral(0), 20);
			}
		};
	}

}
