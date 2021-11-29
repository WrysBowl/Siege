package net.siegerpg.siege.core.crates.dropTables;


import net.siegerpg.siege.core.crates.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.uncommon.*;

import java.util.HashMap;

public class UncommonDropTable extends CosmeticDropTable {

	public UncommonDropTable() {

		dropTable = new HashMap<>() {
			{
				put(new Bee(0), 10);
				put(new CrusaderHelmet(0), 10);
				put(new DavyJonesCap(0), 10);
				put(new GooBall(0), 10);
				put(new WiseGuy(0), 10);
				put(new WitchHat(0), 10);

				put(new SlimeBlock(0), 20);
				put(new StoneFace(0), 20);
				put(new AcaciaWood(0), 20);
				put(new BirchWood(0), 20);
				put(new BlueIce(0), 20);
				put(new BrownMushroom(0), 20);
				put(new CoalOre(0), 20);
				put(new CrimsonHyphae(0), 20);
				put(new DarkOakWood(0), 20);
				put(new DiamondOre(0), 20);
				put(new EmeraldOre(0), 20);
				put(new GoldOre(0), 20);
				put(new Ice(0), 20);
				put(new IronOre(0), 20);
				put(new JungleWood(0), 20);
				put(new LapisOre(0), 20);
				put(new MushroomStem(0), 20);
				put(new OakWood(0), 20);
				put(new PackedIce(0), 20);
				put(new RedMushroom(0), 20);
				put(new RedstoneOre(0), 20);
				put(new SpruceWood(0), 20);
				put(new WarpedHyphae(0), 20);
			}
		};
	}

}
