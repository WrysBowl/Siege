package net.siegerpg.siege.core.commands.admin.dailyRewards.rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.SpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward30 extends DailyReward {

	public DailyReward30() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false).asQuantity(15),
						new SpiritKey(0).getUpdatedItem(false).asQuantity(3)
				},
				30,
				5000,
				2000);

	}

}
