package net.siegerpg.siege.core.commands.admin.questRewards.rewards;

import net.siegerpg.siege.core.commands.admin.questRewards.QuestReward;
import net.siegerpg.siege.core.items.implemented.armor.helmet.StrawHelmet;
import org.bukkit.inventory.ItemStack;

public class JoeTheWeaver extends QuestReward {

	public JoeTheWeaver() {
		super(new ItemStack[]{ new StrawHelmet(50).getUpdatedItem(false) }, "joeTheWeaver", 50, 20);
	}

}
