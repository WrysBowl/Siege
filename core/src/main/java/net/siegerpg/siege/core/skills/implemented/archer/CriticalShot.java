package net.siegerpg.siege.core.skills.implemented.archer;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class CriticalShot extends Skill {

	public CriticalShot () {
		this.ID = 1;
		this.SKILL = this;

		this.DISPLAY_ITEM = new ItemStack(Material.TIPPED_ARROW);
		this.DISPLAY_ITEM.getItemMeta().displayName(Utils.lore("<blue>Critical Shot"));
		this.DISPLAY_ITEM.lore(new ArrayList<>() {{
			add(Utils.lore(""));
			add(Utils.lore(""));
			add(Utils.lore(""));
			add(Utils.lore(""));
			add(Utils.lore(""));
			add(Utils.lore(""));
		}});
		this.MANA_COST = 10;
		this.CHILDREN = new HashMap<>() {{
			put(1, new CriticalShot());
		}};
		this.TRIGGER = new ArrayList<>() {{
			add(Action.LEFT_CLICK_AIR);
			add(Action.LEFT_CLICK_AIR);
			add(Action.LEFT_CLICK_AIR);
		}};
	}

	public void skillAction (PlayerInteractEvent e) {

	}
}
