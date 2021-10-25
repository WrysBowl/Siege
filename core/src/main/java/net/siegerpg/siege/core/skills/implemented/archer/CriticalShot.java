package net.siegerpg.siege.core.skills.implemented.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class CriticalShot extends Skill {

    public CriticalShot(){
        ID = 1;
        SKILL = this;

        DISPLAY_ITEM = new ItemStack(Material.TIPPED_ARROW);
        DISPLAY_ITEM.getItemMeta().displayName(Utils.lore("<blue>Critical Shot"));
        DISPLAY_ITEM.lore(new ArrayList<>(){{
	        this.add(Utils.lore(""));
	        this.add(Utils.lore(""));
	        this.add(Utils.lore(""));
	        this.add(Utils.lore(""));
	        this.add(Utils.lore(""));
	        this.add(Utils.lore(""));
        }});
        MANA_COST = 10;
        CHILDREN = new HashMap<>(){{
	        this.put(1, new CriticalShot());
        }};
        TRIGGER = new ArrayList<>(){{
	        this.add(Action.LEFT_CLICK_AIR);
	        this.add(Action.LEFT_CLICK_AIR);
	        this.add(Action.LEFT_CLICK_AIR);
        }};
    }

    public void skillAction(final PlayerInteractEvent e) {

    }
}
