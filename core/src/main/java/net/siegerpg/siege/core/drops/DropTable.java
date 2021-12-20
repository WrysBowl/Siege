package net.siegerpg.siege.core.drops;

import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class DropTable {
	int goldMin;
	int goldMax;
	int expMin;
	int expMax;
	Reward[] rewards;

	public ArrayList< ItemStack > calculateRewards(double luckChance) {

		ArrayList< ItemStack > itemList = new ArrayList<>();
		for (Reward reward : rewards) {
			if (!Utils.randTest(reward.chance)) continue;
			for (double i = luckChance; i >= 0; i -= 100) {
				itemList.add(reward.item);
				if (i <= 100 && Utils.randTest(i)) {
					itemList.add(reward.item);
				}
			}
		}
		return itemList;
	}

	public Integer getGold(boolean rand) {

		if (rand) {
			return (int) Math.floor(Math.random() * (goldMax - goldMin + 1) + goldMin);
		}
		return goldMax;
	}

	public Integer getExp(boolean rand) {

		if (rand) {
			return (int) Math.floor(Math.random() * (expMax - expMin + 1) + expMin);
		}
		return expMax;
	}
	public Reward[] getRewards() {
		return rewards;
	}
	public int getGoldMin() {

		return goldMin;
	}
	public int getGoldMax() {

		return goldMax;
	}
	public int getExpMax() {

		return expMax;
	}

	public int getExpMin() {

		return expMin;
	}
}
