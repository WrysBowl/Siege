package net.siegerpg.siege.core.crates.dropTables;


import net.siegerpg.siege.core.crates.CosmeticDropTable;
import net.siegerpg.siege.core.drops.mobs.twilight.passive.Crow;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.common.AnonMask;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.epic.*;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.uncommon.CrusaderHelmet;

import java.util.HashMap;

public class EpicDropTable extends CosmeticDropTable {
    public EpicDropTable() {
        dropTable = new HashMap<>(){
            {
                put(new CarrotOnAStick(0), 10);
                put(new Crown(0), 10);
                put(new HotHead(0), 10);
                put(new Noteworthy(0), 10);
                put(new RedHeadphones(0), 10);
                put(new Spongebob(0), 10);
                put(new SquidHead(0), 10);
            }
        };
    }
}
