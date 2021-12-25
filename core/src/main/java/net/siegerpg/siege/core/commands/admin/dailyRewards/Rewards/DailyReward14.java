package net.siegerpg.siege.core.commands.admin.dailyRewards.Rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward14 extends DailyReward {

	public DailyReward14() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false).asQuantity(4)
				},
				14,
				2000,
				800);

	}

}
