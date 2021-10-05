package net.siegerpg.siege.core.crates.crates;

import net.siegerpg.siege.core.crates.dropTables.CosmeticDropTable;
import net.siegerpg.siege.core.dungeons.Dungeon;
import net.siegerpg.siege.core.dungeons.DungeonCommand;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.Map;

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
    public CosmeticDropTable dropTable;
    public CustomKey key;

    public void commonWin(Location loc) {}
    public void uncommonWin(Location loc) {}
    public void rareWin(Location loc) {}
    public void epicWin(Location loc) {}
    public void legendaryWIn(Location loc) {}
}

