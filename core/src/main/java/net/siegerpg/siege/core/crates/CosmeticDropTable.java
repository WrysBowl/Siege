package net.siegerpg.siege.core.crates;

import net.siegerpg.siege.core.dungeons.Dungeon;
import net.siegerpg.siege.core.fishing.baits.BaitStats;
import net.siegerpg.siege.core.fishing.fish.Fish;
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic;
import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CosmeticDropTable {

    public HashMap<CustomCosmetic, Integer> dropTable; //cosmetic and weight

    //Method used to pick a random item from a drop table
    public CustomCosmetic pickItem() {
        double totalWeight = 0;
        for (final Map.Entry<CustomCosmetic, Integer> entry : this.dropTable.entrySet()) {
            final Integer value = entry.getValue();
            totalWeight += value;
        }

        int weight = 0;
        final double random = Math.random() * totalWeight;
        for (final Map.Entry<CustomCosmetic, Integer> entry : this.dropTable.entrySet()) {
            final CustomCosmetic key = entry.getKey();
            final Integer value = entry.getValue();

            weight += value;
            if (random > weight) continue; //if the random number is above the totalWeight
            return key;
        }
        return this.dropTable.entrySet().iterator().next().getKey();
    }
}
