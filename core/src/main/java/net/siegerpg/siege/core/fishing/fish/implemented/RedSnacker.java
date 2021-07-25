package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.FishStats;

public class RedSnacker extends FishCore {

    public RedSnacker(){
        super(new FishStats(new double[] {90, 110}, 20, 0.2, 10, 90, 5, 610002), "Red Snacker");
    }
}
