package net.siegerpg.siege.core.crates.cosmetics;

import net.siegerpg.siege.core.items.CustomItem;

import java.util.HashMap;
import java.util.Map;

public class CosmeticDropTable {

	public HashMap< CustomItem, Integer > dropTable; //cosmetic and weight

	//Method used to pick a random item from a drop table
	public CustomItem pickItem() {

		double totalWeight = 0;
		for (Map.Entry< CustomItem, Integer > entry : dropTable.entrySet()) {
			Integer value = entry.getValue();
			totalWeight += value;
		}

		int weight = 0;
		double random = Math.random() * totalWeight;
		for (Map.Entry< CustomItem, Integer > entry : dropTable.entrySet()) {
			CustomItem key = entry.getKey();
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
