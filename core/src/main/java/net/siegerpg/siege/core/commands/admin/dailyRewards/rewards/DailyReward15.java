package net.siegerpg.siege.core.commands.admin.dailyRewards.rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.SuperiorKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward15 extends DailyReward {

	public DailyReward15() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false).asQuantity(3),
						new SuperiorKey().getUpdatedItem(false).asQuantity(1)
				},
				15,
				2200,
				900);

	}

}
