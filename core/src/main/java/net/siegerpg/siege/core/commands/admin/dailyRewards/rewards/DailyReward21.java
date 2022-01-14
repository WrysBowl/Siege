package net.siegerpg.siege.core.commands.admin.dailyRewards.rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward21 extends DailyReward {

	public DailyReward21() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false).asQuantity(2)
				},
				21,
				2900,
				1250);

	}

}
