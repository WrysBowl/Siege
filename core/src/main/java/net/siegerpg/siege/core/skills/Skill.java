package net.siegerpg.siege.core.skills;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.implemented.archer.CriticalShot;
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
	public @Nullable
	HashMap< StatTypes, Double > STATS;
	public @Nullable
	HashMap< Integer, Skill > CHILDREN;
	public @Nullable
	ArrayList< Action > TRIGGER;

	public Skill() {

		this.ID = 0;
		this.SKILL = this;
		this.MANA_COST = 0;
		STATS.put(StatTypes.LUCK, 0.0);
		STATS.put(StatTypes.STRENGTH, 0.0);
		STATS.put(StatTypes.DEFENSE, 0.0);
		STATS.put(StatTypes.HEALTH, 0.0);
		STATS.put(StatTypes.REGENERATION, 0.0);
		STATS.put(StatTypes.MANA, 0.0);
		STATS.put(StatTypes.MANA_REGEN, 0.0);

		CHILDREN.put(1, new CriticalShot());

		this.DISPLAY_ITEM = new ItemStack(Material.BEDROCK);
	}

	public Skill(int id, @Nullable HashMap< StatTypes, Double > stats, @Nullable HashMap< Integer, Skill > children, int manaCost, @Nullable ArrayList< Action > trigger, ItemStack displayItem) {

		this.ID = id;
		this.STATS = stats;
		this.CHILDREN = children;
		this.MANA_COST = manaCost;
		this.TRIGGER = trigger;
		this.DISPLAY_ITEM = displayItem;
	}

	public Skill(Skill skill) {

		this.SKILL = skill;
	}

	public HashMap< StatTypes, Double > getStats() {

		return this.STATS;
	}

	public int getID() {

		return this.ID;
	}

	public Skill getSkill() {

		return this;
	}

	public HashMap< Integer, Skill > getChildren() {

		return this.CHILDREN;
	}

	public ItemStack getDisplayItem() {

		return this.DISPLAY_ITEM;
	}

	public Integer getManaCost() {

		return this.MANA_COST;
	}

	public ArrayList< Action > getTrigger() {

		return this.TRIGGER;
	}

	public void skillAction(PlayerInteractEvent e) {

		Bukkit
				.getLogger()
				.info(Utils.tacc("&cPlayer tried to activate invalid skill!"));
	}

}
