package net.siegerpg.siege.core.fishing.droptables;

import net.siegerpg.siege.core.fishing.catches.fish.*;
import net.siegerpg.siege.core.fishing.catches.loot.*;
import net.siegerpg.siege.core.fishing.catches.loot.gems.*;
import net.siegerpg.siege.core.fishing.catches.loot.webstore.CommonKey;
import net.siegerpg.siege.core.fishing.catches.loot.webstore.NormalKey;
import net.siegerpg.siege.core.fishing.catches.loot.webstore.UncommonKey;

import java.util.HashMap;

public class OakFishTable extends FishDropTable {
    public OakFishTable() {
        this.fishDropTable = new HashMap<>(){
            {
                put(new Catastrophe(), 60.0);
                put(new Codzilla(), 100.0);
                put(new MrKrabs(), 70.0);
                put(new MrsPuff(), 50.0);
                put(new PistolWhipper(), 50.0);
                put(new StingWhip(), 40.0);

                put(new Bearacuda(), 40.0);
                put(new RedSnacker(), 80.0);

                //LOOT
                put(new SusStew(), 5.0);
                put(new Sugar(), 30.0);
                put(new RawHealth(), 2.0);
                put(new RawTough(), 2.0);
                put(new RawStrength(), 2.0);
                put(new RawLuck(), 2.0);
                put(new RawRegeneration(), 2.0);

                put(new CommonKey(), 5.5);
                put(new NormalKey(), 5.0);
                put(new CrackedHealth(), 5.0);
                put(new CrackedTough(), 5.0);
                put(new CrackedStrength(), 5.0);
                put(new CrackedLuck(), 5.0);
                put(new CrackedRegeneration(), 5.0);
            }
        };
    }
}
