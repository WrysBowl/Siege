package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.Fish;

public class StingWhip extends FishCore {

    public StingWhip(){
        super(new Fish(new double[] {200, 230}, 30, 0.2, 15, 45, 7), "Sting Whip");
    }
}
