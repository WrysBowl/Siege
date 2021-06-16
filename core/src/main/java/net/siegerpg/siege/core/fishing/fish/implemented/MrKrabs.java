package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.Fish;

public class MrKrabs extends FishCore {

    public MrKrabs(){
        super(new Fish(new double[] {5, 15}, 6, 0.1, 8, 80, 4), "Mr. Krabs");
    }
}
