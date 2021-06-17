package net.siegerpg.siege.core.fishing.fish.implemented;

import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.fishing.fish.Fish;

public class FlashyShark extends FishCore {

    public FlashyShark(){
        super(new Fish(new double[] {360, 400}, 30, 0.5, 16, 5, 10), "Flashy Shark");
    }
}
