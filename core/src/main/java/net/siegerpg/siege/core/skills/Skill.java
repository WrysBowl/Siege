package net.siegerpg.siege.core.skills;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.implemented.archer.CriticalShot;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class Skill {

    //Decode needs to be static for us to reference it, but then skillTypes need to be static, and so I transferred
    //all the hashmaps and methods to another class
    int ID;
    Skill SKILL;
    ItemStack DISPLAY_ITEM;
    Integer MANA_COST;
    @Nullable HashMap<StatTypes,Double> STATS;
    @Nullable HashMap<Integer, Skill> CHILDREN;
    @Nullable ArrayList<Action> TRIGGER;

    public Skill(){
        this.ID = 0;
        this.SKILL = this;
        this.MANA_COST = 0;
        this.STATS = new HashMap<>(){{
            put(StatTypes.LUCK, 0.0);
            put(StatTypes.STRENGTH, 0.0);
            put(StatTypes.TOUGHNESS, 0.0);
            put(StatTypes.HEALTH, 0.0);
            put(StatTypes.REGENERATION, 0.0);
            put(StatTypes.MANA, 0.0);
            put(StatTypes.MANA_REGEN, 0.0); }
        };
        this.CHILDREN = new HashMap<>(){
            {
                put(1, new CriticalShot());
            }
        };
        this.DISPLAY_ITEM = new ItemStack(Material.BEDROCK);
    }
    public Skill(int id, @Nullable HashMap<StatTypes,Double> stats, @Nullable HashMap<Integer, Skill> children, int manaCost, @Nullable ArrayList<Action> trigger) {
        this.ID = id;
        this.STATS = stats;
        this.CHILDREN = children;
        this.MANA_COST = manaCost;
        this.TRIGGER = trigger;
    }
    public Skill(Skill skill) {
        this.SKILL = skill;
    }

    public HashMap<StatTypes,Double> getStats() {
        return this.STATS;
    }
    public int getID() {
        return this.ID;
    }
    public Skill getSkill() {
        return this;
    }
    public HashMap<Integer, Skill> getChildren() {
        return this.CHILDREN;
    }
    public ItemStack getDisplayItem() {
        return this.DISPLAY_ITEM;
    }
    public Integer getManaCost() {
        return this.MANA_COST;
    }
    public ArrayList<Action> getTrigger(){
        return this.TRIGGER;
    }
    public void skillAction(PlayerInteractEvent e) {
        Bukkit.getLogger().info(Utils.tacc("&cPlayer tried to activate invalid skill!"));
    }
}
