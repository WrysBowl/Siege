package net.siegerpg.siege.core.commands.admin.dailyRewards.rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.SuperiorKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward20 extends DailyReward {

	public DailyReward20() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false).asQuantity(6),
						new SuperiorKey(0).getUpdatedItem(false).asQuantity(3)
				},
				20,
				2800,
				1200);

	}

}
