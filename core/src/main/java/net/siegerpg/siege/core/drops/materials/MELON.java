package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Watermelon;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat;
import org.bukkit.Material;

public class MELON extends BlockDropTable {
    public MELON() {
        super(200, Material.MELON, 5, 7, 4, 6, new Reward[]{
                new Reward(new Watermelon(0).getUpdatedItem(false).asQuantity(3), 100.0),
                new Reward(new Watermelon(0).getUpdatedItem(false).asQuantity(5), 10.0),
        });
    }
}