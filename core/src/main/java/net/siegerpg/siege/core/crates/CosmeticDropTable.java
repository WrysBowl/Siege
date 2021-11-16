package net.siegerpg.siege.core.crates;

import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic;

import java.util.HashMap;
import java.util.Map;

public class CosmeticDropTable {

	public HashMap< CustomCosmetic, Integer > dropTable; //cosmetic and weight

	//Method used to pick a random item from a drop table
	public CustomCosmetic pickItem() {

		double totalWeight = 0;
		for (Map.Entry< CustomCosmetic, Integer > entry : dropTable.entrySet()) {
			Integer value = entry.getValue();
			totalWeight += value;
		}

		int weight = 0;
		double random = Math.random() * totalWeight;
		for (Map.Entry< CustomCosmetic, Integer > entry : dropTable.entrySet()) {
			CustomCosmetic key = entry.getKey();
			Integer value = entry.getValue();

			weight += value;
			if (random > weight) continue; //if the random number is above the totalWeight
			return key;
		}
		return dropTable
				.entrySet()
				.iterator()
				.next()
				.getKey();
	}

}
