package net.siegerpg.siege.core.skills;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.implemented.archer.CriticalShot;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class Skill {

    //Decode needs to be static for us to reference it, but then skillTypes need to be static, and so I transferred
    //all the hashmaps and methods to another class
    public int ID;
    public Skill SKILL;
    public ItemStack DISPLAY_ITEM;
    public Integer MANA_COST;
    @Nullable
    public
    HashMap<StatTypes, Double> STATS;
    @Nullable
    public
    HashMap<Integer, Skill> CHILDREN;
    @Nullable
    public
    ArrayList<Action> TRIGGER;

    public Skill() {
        ID = 0;
        SKILL = this;
        MANA_COST = 0;
	    this.STATS.put(StatTypes.LUCK, 0.0);
	    this.STATS.put(StatTypes.STRENGTH, 0.0);
	    this.STATS.put(StatTypes.TOUGHNESS, 0.0);
	    this.STATS.put(StatTypes.HEALTH, 0.0);
	    this.STATS.put(StatTypes.REGENERATION, 0.0);
	    this.STATS.put(StatTypes.MANA, 0.0);
	    this.STATS.put(StatTypes.MANA_REGEN, 0.0);

	    this.CHILDREN.put(1, new CriticalShot());

        DISPLAY_ITEM = new ItemStack(Material.BEDROCK);
    }

    public Skill(final int id, @Nullable final HashMap<StatTypes, Double> stats, @Nullable final HashMap<Integer, Skill> children, final int manaCost, @Nullable final ArrayList<Action> trigger, final ItemStack displayItem) {
        ID = id;
        STATS = stats;
        CHILDREN = children;
        MANA_COST = manaCost;
        TRIGGER = trigger;
        DISPLAY_ITEM = displayItem;
    }

    public Skill(final Skill skill) {
        SKILL = skill;
    }

    public HashMap<StatTypes, Double> getStats() {
        return STATS;
    }

    public int getID() {
        return ID;
    }

    public Skill getSkill() {
        return this;
    }

    public HashMap<Integer, Skill> getChildren() {
        return CHILDREN;
    }

    public ItemStack getDisplayItem() {
        return DISPLAY_ITEM;
    }

    public Integer getManaCost() {
        return MANA_COST;
    }

    public ArrayList<Action> getTrigger() {
        return TRIGGER;
    }

    public void skillAction(final PlayerInteractEvent e) {
        Bukkit.getLogger().info(Utils.tacc("&cPlayer tried to activate invalid skill!"));
    }
}
