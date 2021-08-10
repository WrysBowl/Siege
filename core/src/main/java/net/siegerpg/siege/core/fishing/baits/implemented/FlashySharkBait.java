package net.siegerpg.siege.core.fishing.baits.implemented;

import net.siegerpg.siege.core.fishing.baits.BaitCore;
import net.siegerpg.siege.core.fishing.baits.BaitStats;
import net.siegerpg.siege.core.fishing.fish.implemented.BigBlueTuna;
import net.siegerpg.siege.core.fishing.fish.implemented.FlashyShark;
import org.bukkit.Material;

public class FlashySharkBait extends BaitCore {
    public FlashySharkBait() {
        super(new BaitStats[]{new BaitStats(new FlashyShark(), 200)}, "Flashy Shark Bait", Material.SEA_PICKLE);
    }
}
