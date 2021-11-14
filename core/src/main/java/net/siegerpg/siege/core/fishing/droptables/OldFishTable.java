package net.siegerpg.siege.core.fishing.droptables;

import net.siegerpg.siege.core.fishing.catches.fish.*;
import net.siegerpg.siege.core.fishing.catches.loot.Sugar;
import net.siegerpg.siege.core.fishing.catches.loot.SusStew;

import java.util.HashMap;

public class OldFishTable extends FishDropTable {
    public OldFishTable() {
        this.fishDropTable = new HashMap<>(){
            {
                put(new Catastrophe(), 90.0);
                put(new Codzilla(), 100.0);
                put(new MrKrabs(), 40.0);
                put(new MrsPuff(), 10.0);
                put(new PistolWhipper(), 30.0);
                put(new StingWhip(), 10.0);

                //LOOT
                put(new SusStew(), 10.0);
                put(new Sugar(), 20.0);
            }
        };
    }
}
