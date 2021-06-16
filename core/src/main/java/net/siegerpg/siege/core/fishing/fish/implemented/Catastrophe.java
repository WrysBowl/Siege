package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.Fish;

public class Catastrophe extends FishCore {

    public Catastrophe(){
        super(new Fish(new double[] {130, 180}, 25, 0.2, 12, 60, 6), "Catastrophe");
    }
}
