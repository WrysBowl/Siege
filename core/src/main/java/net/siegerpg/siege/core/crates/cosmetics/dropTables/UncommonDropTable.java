package net.siegerpg.siege.core.crates.cosmetics.dropTables;


import net.siegerpg.siege.core.crates.cosmetics.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.uncommon.*;
import net.siegerpg.siege.core.items.implemented.misc.mounts.CatMount;
import net.siegerpg.siege.core.items.implemented.misc.mounts.LlamaMount;
import net.siegerpg.siege.core.items.implemented.misc.mounts.MooshroomMount;
import net.siegerpg.siege.core.items.implemented.misc.mounts.SpiderMount;

import java.util.HashMap;

public class UncommonDropTable extends CosmeticDropTable {

	public UncommonDropTable() {

		dropTable = new HashMap<>() {
			{
				put(new Bee(), 10);
				put(new DavyJonesCap(), 10);
				put(new GooBall(), 10);
				put(new WiseGuy(), 10);
				put(new WitchHat(), 10);
				put(new CatMount(), 15);
				put(new MooshroomMount(), 15);
				put(new SpiderMount(), 15);
				put(new LlamaMount(), 15);

				put(new SlimeBlock(), 20);
				put(new StoneFace(), 20);
				put(new AcaciaWood(), 20);
				put(new BirchWood(), 20);
				put(new BlueIce(), 20);
				put(new BrownMushroom(), 20);
				put(new CoalOre(), 20);
				put(new CrimsonHyphae(), 20);
				put(new DarkOakWood(), 20);
				put(new DiamondOre(), 20);
				put(new EmeraldOre(), 20);
				put(new GoldOre(), 20);
				put(new Ice(), 20);
				put(new IronOre(), 20);
				put(new JungleWood(), 20);
				put(new LapisOre(), 20);
				put(new MushroomStem(), 20);
				put(new OakWood(), 20);
				put(new PackedIce(), 20);
				put(new RedMushroom(), 20);
				put(new RedstoneOre(), 20);
				put(new SpruceWood(), 20);
				put(new WarpedHyphae(), 20);
			}
		};
	}

}
