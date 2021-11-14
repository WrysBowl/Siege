package net.siegerpg.siege.core.fishing.droptables;

import net.siegerpg.siege.core.fishing.catches.fish.*;
import net.siegerpg.siege.core.fishing.catches.loot.*;
import net.siegerpg.siege.core.fishing.catches.loot.webstore.CommonKey;
import net.siegerpg.siege.core.fishing.catches.loot.webstore.UncommonKey;

import java.util.HashMap;

public class OakFishTable extends FishDropTable {
    public OakFishTable() {
        this.fishDropTable = new HashMap<>(){
            {
                put(new Catastrophe(), 70.0);
                put(new Codzilla(), 80.0);
                put(new MrKrabs(), 40.0);
                put(new MrsPuff(), 20.0);
                put(new PistolWhipper(), 30.0);
                put(new StingWhip(), 35.0);

                put(new Bearacuda(), 20.0);
                put(new RedSnacker(), 70.0);

                //LOOT
                put(new SusStew(), 10.0);
                put(new CommonKey(), 5.0);
                put(new UncommonKey(), 2.0);

            }
        };
    }
}
