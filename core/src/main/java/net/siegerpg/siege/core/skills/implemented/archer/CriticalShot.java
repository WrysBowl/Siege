package net.siegerpg.siege.core.skills.implemented.archer;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class CriticalShot extends Skill {

    int ID;
    Skill SKILL;
    ItemStack DISPLAY_ITEM;
    @Nullable HashMap<StatTypes,Double> STATS;
    @Nullable HashMap<Integer, Skill> CHILDREN;
    @Nullable Integer MANA_COST;
    @Nullable ArrayList<Action> TRIGGER;


    public CriticalShot(){
        this.ID = 1;
        this.SKILL = this;

        this.DISPLAY_ITEM = new ItemStack(Material.TIPPED_ARROW);
        this.DISPLAY_ITEM.getItemMeta().displayName(Utils.lore("<blue>Critical Shot"));
        this.DISPLAY_ITEM.lore(new ArrayList<>(){{
            add(Utils.lore(""));
            add(Utils.lore(""));
            add(Utils.lore(""));
            add(Utils.lore(""));
            add(Utils.lore(""));
            add(Utils.lore(""));
        }});
        this.CHILDREN = new HashMap<>(){{
            put(1, new CriticalShot());
        }};
        this.TRIGGER = new ArrayList<>(){{
            add(Action.LEFT_CLICK_AIR);
            add(Action.LEFT_CLICK_AIR);
            add(Action.LEFT_CLICK_AIR);
        }};
    }

    public void skillAction(PlayerInteractEvent e) {

    }
}
