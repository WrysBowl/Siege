package net.siegerpg.siege.core.fishing.droptables;

import net.siegerpg.siege.core.fishing.catches.fish.*;
import net.siegerpg.siege.core.fishing.catches.loot.SusStew;
import net.siegerpg.siege.core.fishing.catches.loot.webstore.CommonKey;
import net.siegerpg.siege.core.fishing.catches.loot.webstore.UncommonKey;

import java.util.HashMap;

public class RefinedFishTable extends FishDropTable {
    public RefinedFishTable() {
        this.fishDropTable = new HashMap<>(){
            {
                put(new Catastrophe(), 60.0);
                put(new Codzilla(), 60.0);
                put(new MrKrabs(), 20.0);
                put(new MrsPuff(), 20.0);
                put(new PistolWhipper(), 20.0);

                put(new Bearacuda(), 40.0);
                put(new RedSnacker(), 80.0);
                put(new StingWhip(), 50.0);

                //LOOT
                put(new SusStew(), 20.0);
                put(new CommonKey(), 10.0);
                put(new UncommonKey(), 5.0);

            }
        };
    }
}
