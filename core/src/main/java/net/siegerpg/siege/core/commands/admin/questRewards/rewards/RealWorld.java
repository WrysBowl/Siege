package net.siegerpg.siege.core.commands.admin.questRewards.rewards;

import net.siegerpg.siege.core.commands.admin.questRewards.QuestReward;
import org.bukkit.inventory.ItemStack;

public class RealWorld extends QuestReward {

	public RealWorld() {
		super(new ItemStack[0], "realWorld", 50, 60);
	}

}
