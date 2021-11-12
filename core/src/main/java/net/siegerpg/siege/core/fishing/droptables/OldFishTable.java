package net.siegerpg.siege.core.fishing.droptables;

import net.siegerpg.siege.core.fishing.catches.fish.*;
import net.siegerpg.siege.core.fishing.catches.fish.implemented.*;

import java.util.HashMap;

public class OldFishTable extends FishDropTable {
    public OldFishTable() {
        this.fishDropTable = new HashMap<>(){
            {
                put(new Bearacuda(), 15.0);
                put(new BigBlueTuna(), 10.0);
                put(new Catastrophe(), 60.0);
                put(new Codzilla(), 100.0);
                put(new FlashyShark(), 5.0);
                put(new MrKrabs(), 80.0);
                put(new MrsPuff(), 60.0);
                put(new PistolWhipper(), 50.0);
                put(new RedSnacker(), 90.0);
                put(new StingWhip(), 45.0);
            }
        };
    }
}
