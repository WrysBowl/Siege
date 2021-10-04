package net.siegerpg.siege.core.crates.dropTables;


import net.siegerpg.siege.core.items.implemented.misc.cosmetics.common.AnonMask;

import java.util.HashMap;

public class NormalDropTable extends CosmeticDropTable{
    public NormalDropTable() {
        dropTable = new HashMap<>(){
            {
                put(new AnonMask(), 10);
            }
        };
    }
}
