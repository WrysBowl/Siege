package net.siegerpg.siege.core.crates.dropTables;


import net.siegerpg.siege.core.crates.CosmeticDropTable;
import net.siegerpg.siege.core.items.implemented.misc.cosmetics.common.*;
import org.bukkit.entity.Pig;

import java.util.HashMap;

public class CommonDropTable extends CosmeticDropTable {
    public CommonDropTable() {
	    this.dropTable = new HashMap<>(){
            {
	            this.put(new AnonMask(0), 10);
	            this.put(new ArrowHead(0), 10);
	            this.put(new BullHorns(0), 10);
	            this.put(new BunnyEars(0), 10);
	            this.put(new GrouchoGlasses(0), 10);
	            this.put(new Mohawk(0), 10);
	            this.put(new PigNose(0), 10);
	            this.put(new SurgicalMask(0), 10);
            }
        };
    }
}
