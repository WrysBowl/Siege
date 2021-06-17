package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.Fish;

public class Codzilla extends FishCore {

    public Codzilla(){
        super(new Fish(new double[] {75, 100}, 20, 0.15, 10, 100, 5), "Codzilla");
    }
}
