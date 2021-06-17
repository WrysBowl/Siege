package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.Fish;

public class MrsPuff extends FishCore {

    public MrsPuff(){
        super(new Fish(new double[] {30, 60}, 12, 0.1, 8, 60, 4), "Mrs. Puff");
    }
}
