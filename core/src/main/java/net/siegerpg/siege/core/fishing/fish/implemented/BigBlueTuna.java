package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.Fish;

public class BigBlueTuna extends FishCore {

    public BigBlueTuna(){
        super(new Fish(new double[] {400, 450}, 45, 0.4, 16, 10, 8), "Big Blue Tuna");
    }
}
