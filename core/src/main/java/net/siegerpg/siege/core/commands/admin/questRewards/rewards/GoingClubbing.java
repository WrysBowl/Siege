package net.siegerpg.siege.core.commands.admin.questRewards.rewards;

import net.siegerpg.siege.core.commands.admin.questRewards.QuestReward;
import net.siegerpg.siege.core.items.implemented.armor.helmet.StrawHelmet;
import org.bukkit.inventory.ItemStack;

public class GoingClubbing extends QuestReward {

	public GoingClubbing() {
		super(new ItemStack[]{ new StrawHelmet(50).getUpdatedItem(false) }, "goingClubbing", 100, 50);
	}

}
