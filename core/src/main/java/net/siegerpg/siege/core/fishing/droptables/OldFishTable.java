package net.siegerpg.siege.core.fishing.droptables;

import net.siegerpg.siege.core.fishing.catches.fish.*;
import net.siegerpg.siege.core.fishing.catches.loot.Sugar;
import net.siegerpg.siege.core.fishing.catches.loot.SusStew;
import net.siegerpg.siege.core.fishing.catches.loot.gems.*;

import java.util.HashMap;

public class OldFishTable extends FishDropTable {
    public OldFishTable() {
        this.fishDropTable = new HashMap<>(){
            {
                put(new Catastrophe(), 90.0);
                put(new Codzilla(), 100.0);
                put(new MrKrabs(), 50.0);
                put(new MrsPuff(), 30.0);
                put(new PistolWhipper(), 50.0);
                put(new StingWhip(), 20.0);

                //LOOT
                put(new SusStew(), 10.0);
                put(new Sugar(), 20.0);
                put(new RawHealth(), 5.0);
                put(new RawTough(), 5.0);
                put(new RawStrength(), 5.0);
                put(new RawLuck(), 5.0);
                put(new RawRegeneration(), 5.0);
            }
        };
    }
}
