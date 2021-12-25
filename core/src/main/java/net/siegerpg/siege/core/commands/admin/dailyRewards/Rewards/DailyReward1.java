package net.siegerpg.siege.core.commands.admin.dailyRewards.Rewards;

import net.siegerpg.siege.core.commands.admin.dailyRewards.DailyReward;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import org.bukkit.inventory.ItemStack;

import java.sql.Array;

public class DailyReward1 extends DailyReward {

	public DailyReward1() {
		super(
				new ItemStack[]{
						new MobKey(0).getUpdatedItem(false)
				},
				1,
				500,
				50);

	}

}
