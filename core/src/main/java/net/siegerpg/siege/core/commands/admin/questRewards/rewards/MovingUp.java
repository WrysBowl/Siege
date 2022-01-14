package net.siegerpg.siege.core.commands.admin.questRewards.rewards;

import net.siegerpg.siege.core.commands.admin.questRewards.QuestReward;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.Club;
import org.bukkit.inventory.ItemStack;

public class MovingUp extends QuestReward {

	public MovingUp() {
		super(new ItemStack[]{ new Club(50).getItem() }, "movingUp", 50, 25);
	}

}
