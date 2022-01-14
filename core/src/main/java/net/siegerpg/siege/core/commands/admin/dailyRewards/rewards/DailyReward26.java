package net.siegerpg.siege.core.commands.admin.dailyRewards.rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward26 extends DailyReward {

	public DailyReward26() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false).asQuantity(3)
				},
				26,
				3500,
				1550);

	}

}
