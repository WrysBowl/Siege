package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.FishStats;

public class PistolWhipper extends FishCore {

    public PistolWhipper(){
        super(new FishStats(new double[] {20, 30}, 8, 0.1, 8, 50, 4), "Pistol Whipper");
    }
}
