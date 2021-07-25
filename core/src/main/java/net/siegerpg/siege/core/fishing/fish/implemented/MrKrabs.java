package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.FishStats;

public class MrKrabs extends FishCore {

    public MrKrabs(){
        super(new FishStats(new double[] {5, 15}, 6, 0.1, 8, 80, 4, 610009), "Mr. Krabs");
    }
}
