package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.FishStats;

public class FlashyShark extends FishCore {

    public FlashyShark(){
        super(new FishStats(new double[] {360, 400}, 30, 0.5, 16, 5, 10), "Flashy Shark");
    }
}
