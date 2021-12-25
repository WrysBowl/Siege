package net.siegerpg.siege.core.commands.admin.dailyRewards.Rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward22 extends DailyReward {

	public DailyReward22() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false).asQuantity(4)
				},
				22,
				3000,
				1300);

	}

}
