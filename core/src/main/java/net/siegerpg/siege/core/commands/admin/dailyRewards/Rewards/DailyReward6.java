package net.siegerpg.siege.core.commands.admin.dailyRewards.Rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward6 extends DailyReward {

	public DailyReward6() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false)
				},
				6,
				1100,
				350);

	}

}
