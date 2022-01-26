package net.siegerpg.siege.core.commands.admin.dailyRewards.rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.SpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward25 extends DailyReward {

	public DailyReward25() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false).asQuantity(10),
						new SpiritKey().getUpdatedItem(false).asQuantity(1)
				},
				25,
				3400,
				1500);

	}

}
