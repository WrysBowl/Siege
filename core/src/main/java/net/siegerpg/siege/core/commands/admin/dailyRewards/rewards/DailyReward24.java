package net.siegerpg.siege.core.commands.admin.dailyRewards.rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward24 extends DailyReward {

	public DailyReward24() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false).asQuantity(8)
				},
				24,
				3200,
				1400);

	}

}
