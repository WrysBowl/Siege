package net.siegerpg.siege.core.commands.admin.dailyRewards.Rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.CommonKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.NormalKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

public class DailyReward5 extends DailyReward {

	public DailyReward5() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false),
						new NormalKey(0).getUpdatedItem(false)
				},
				5,
				1000,
				300);

	}

}
