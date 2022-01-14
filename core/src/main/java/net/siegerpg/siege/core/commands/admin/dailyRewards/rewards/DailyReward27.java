package net.siegerpg.siege.core.commands.admin.dailyRewards.rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward27 extends DailyReward {

	public DailyReward27() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false).asQuantity(6)
				},
				27,
				3600,
				1600);

	}

}
