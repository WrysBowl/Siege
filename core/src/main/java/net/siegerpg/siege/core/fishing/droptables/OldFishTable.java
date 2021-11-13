package net.siegerpg.siege.core.fishing.droptables;

import net.siegerpg.siege.core.fishing.catches.fish.*;

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
            }
        };
    }
}
