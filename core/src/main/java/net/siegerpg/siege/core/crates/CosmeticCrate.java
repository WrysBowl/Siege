package net.siegerpg.siege.core.crates;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.crates.dropTables.*;
import net.siegerpg.siege.core.items.enums.Rarity;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.*;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class CosmeticCrate {
    /**
     * CRATES GUIDE
     * 
     * -Cosmetic crates should have 5 tiers of cosmetics from which players can win using a key
     * Keys should be used to pick an item from its specific drop table
     * Drop tables use a weighted loot system to determine cosmetic drop chance
     * -Each cosmetic inside a drop table has its own class that determines the special effects/messages to be played when won
     * 
     * There should be infrastructure for multiple drop tables with multiple different cosmetics and weight values
     */
    public static HashMap<CustomKey, CosmeticDropTable> crates = new HashMap<>(){
        {
	        this.put(new NormalKey(0), new NormalDropTable());
	        this.put(new SuperiorKey(0), new SuperiorDropTable());
	        this.put(new SpiritKey(0), new SpiritDropTable());
	        this.put(new CommonKey(0), new CommonDropTable());
	        this.put(new UncommonKey(0), new UncommonDropTable());
	        this.put(new RareKey(0), new RareDropTable());
	        this.put(new EpicKey(0), new EpicDropTable());
	        this.put(new LegendaryKey(0), new LegendaryDropTable());
        }
    };

    public static void commonWin(final Location loc) {}
    public static void uncommonWin(final Location loc) {}
    public static void rareWin(final Location loc) {}
    public static void epicWin(final Location loc) {}
    public static void legendaryWIn(final Location loc) {}
}

