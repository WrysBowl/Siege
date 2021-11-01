package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.PumpkinPie;
import net.siegerpg.siege.core.items.implemented.misc.food.Watermelon;
import org.bukkit.Material;

public class PUMPKIN extends BlockDropTable {
    public PUMPKIN() {
        super(200, Material.PUMPKIN, 5, 7, 4, 6, new Reward[]{
                new Reward(new PumpkinPie(0).getUpdatedItem(false).asQuantity(1), 100.0),
                new Reward(new PumpkinPie(0).getUpdatedItem(false).asQuantity(3), 10.0),
        });
    }
}
