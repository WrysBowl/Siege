package net.siegerpg.siege.core.commands.admin.dailyRewards.Rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward17 extends DailyReward {

	public DailyReward17() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false).asQuantity(2)
				},
				17,
				2400,
				1000);

	}

}
