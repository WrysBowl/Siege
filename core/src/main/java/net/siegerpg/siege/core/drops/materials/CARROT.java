package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Carrot;
import net.siegerpg.siege.core.items.implemented.misc.food.Watermelon;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat;
import org.bukkit.Material;

public class CARROT extends BlockDropTable {
    public CARROT() {
        super(200, Material.CARROT, 0, 0, 0, 0, new Reward[]{
                new Reward(new Carrot(0).getUpdatedItem(false).asQuantity(1), 100.0),
                new Reward(new Carrot(0).getUpdatedItem(false).asQuantity(3), 10.0),
        });
    }
}
