package net.siegerpg.siege.core.crates.cosmetics;

import net.siegerpg.siege.core.crates.cosmetics.dropTables.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.*;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import org.bukkit.Location;

import java.util.HashMap;

public class CosmeticCrate {

	/**
	 * CRATES GUIDE
	 * <p>
	 * -Cosmetic crates should have 5 tiers of cosmetics from which players can win using a key
	 * Keys should be used to pick an item from its specific drop table
	 * Drop tables use a weighted loot system to determine cosmetic drop chance
	 * -Each cosmetic inside a drop table has its own class that determines the special effects/messages to be played when won
	 * <p>
	 * There should be infrastructure for multiple drop tables with multiple different cosmetics and weight values
	 */
	public static HashMap< CustomKey, CosmeticDropTable > crates = new HashMap<>() {
		{
			put(new NormalKey(0), new NormalDropTable());
			put(new SuperiorKey(0), new SuperiorDropTable());
			put(new SpiritKey(0), new SpiritDropTable());
			put(new CommonKey(0), new CommonDropTable());
			put(new UncommonKey(0), new UncommonDropTable());
			put(new RareKey(0), new RareDropTable());
			put(new EpicKey(0), new EpicDropTable());
			put(new LegendaryKey(0), new LegendaryDropTable());
		}
	};

	public static void commonWin(Location loc) {

	}

	public static void uncommonWin(Location loc) {

	}

	public static void rareWin(Location loc) {

	}

	public static void epicWin(Location loc) {

	}

	public static void legendaryWIn(Location loc) {

	}

}

