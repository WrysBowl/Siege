package net.siegerpg.siege.core.skills.implemented.archer;

import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.subTypes.ArcherSkill;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CriticalShot extends ArcherSkill {

    int ID;
    @Nullable HashMap<StatTypes,Double> STATS;
    Skill SKILL;
    boolean activeSkill;
    @Nullable HashMap<Integer, ArcherSkill> CHILDREN;
    ItemStack displayItem;

    public CriticalShot(){
        this.ID = 1;
        this.SKILL = this;
        this.activeSkill = true;
        this.CHILDREN = new HashMap<>(){
            {
            put(1, new CriticalShot());
            }
        };
        this.displayItem = new ItemStack(Material.TIPPED_ARROW);
        this.displayItem.getItemMeta().displayName(Utils.lore("<blue>Critical Shot"));
        this.displayItem.lore(new ArrayList<>(){
            {
                add(Utils.lore(""));
                add(Utils.lore(""));
                add(Utils.lore(""));
                add(Utils.lore(""));
                add(Utils.lore(""));
                add(Utils.lore(""));
            }
        });
    }
    public CriticalShot(int id, @Nullable HashMap<StatTypes,Double> stats, @Nullable HashMap<Integer, ArcherSkill> children, ItemStack displayItem) {
        this.ID = id;
        this.STATS = stats;
        this.CHILDREN = children;
        this.displayItem = displayItem;

    }
    public CriticalShot(Skill skill) {
        this.SKILL = skill;
    }

    public void skillAction(PlayerInteractEvent e) {
        if(activeSkill) {
            return;
        }
    }
}
