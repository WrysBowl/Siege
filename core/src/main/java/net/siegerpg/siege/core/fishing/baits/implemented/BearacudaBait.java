package net.siegerpg.siege.core.fishing.baits.implemented;

import net.siegerpg.siege.core.fishing.baits.BaitCore;
import net.siegerpg.siege.core.fishing.baits.BaitStats;
import net.siegerpg.siege.core.fishing.fish.implemented.Bearacuda;
import org.bukkit.Material;

public class BearacudaBait extends BaitCore {
    public BearacudaBait() {
        super(new BaitStats[]{new BaitStats(new Bearacuda(), 200)}, "Bearacuda Bait", Material.SEA_PICKLE);
    }
}
