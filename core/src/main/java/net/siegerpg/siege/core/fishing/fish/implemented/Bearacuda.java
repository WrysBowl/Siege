package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.Fish;

public class Bearacuda extends FishCore {

    public Bearacuda(){
        super(new Fish(new double[] {60, 100}, 15, 0.5, 10, 15, 10), "Bearacuda");
    }
}
