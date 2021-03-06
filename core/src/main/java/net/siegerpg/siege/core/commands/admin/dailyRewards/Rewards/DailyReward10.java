package net.siegerpg.siege.core.commands.admin.dailyRewards.Rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.NormalKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward10 extends DailyReward {

	public DailyReward10() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false).asQuantity(3),
						new NormalKey(0).getUpdatedItem(false).asQuantity(3)
				},
				10,
				1600,
				600);

	}

}
