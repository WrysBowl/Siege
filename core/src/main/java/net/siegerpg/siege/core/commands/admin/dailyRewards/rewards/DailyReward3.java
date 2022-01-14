package net.siegerpg.siege.core.commands.admin.dailyRewards.rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward3 extends DailyReward {

	public DailyReward3() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false).asQuantity(3)
				},
				3,
				700,
				150);

	}

}
