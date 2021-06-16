package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.Fish;

public class RedSnacker extends FishCore {

    public RedSnacker(){
        super(new Fish(new double[] {90, 110}, 20, 0.2, 10, 90, 5), "Red Snacker");
    }
}
