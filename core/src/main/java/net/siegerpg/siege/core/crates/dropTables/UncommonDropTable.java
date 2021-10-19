package net.siegerpg.siege.core.crates.dropTables;


import net.siegerpg.siege.core.crates.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.common.AnonMask;

import java.util.HashMap;

public class UncommonDropTable extends CosmeticDropTable {
    public UncommonDropTable() {
        dropTable = new HashMap<>(){
            {
                put(new AnonMask(0), 10);
            }
        };
    }
}