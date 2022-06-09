package net.siegerpg.siege.core.skills;

import org.bukkit.event.block.*;

import java.util.*;

public enum SkillClass {
	MAGE("Mage", "mage", "[R-Click]"),
	WARRIOR("Warrior", "warrior", "[R-Click]"),
	ARCHER("Archer", "archer", "[L-Click]");

	/**
	 * The name assigned to the class
	 */
	private String name;
	/**
	 * The id of the class (should not change unless you want people to lose skill progress)
	 */
	private String id;
	/**
	 * The action to activate the skill
	 */
	private String action;

	public String getName() {

		return this.name;
	}

	public String getId() {

		return this.id;
	}

	public String getAction() {

		return this.action;
	}

	private SkillClass(String name, String id, String action) {

		this.id = id;
		this.name = name;
		this.action = action;

	}

	public List<Action> getClickActions() {
		if (this.action.equals("[L-Click]")) {
			return List.of(Action.LEFT_CLICK_AIR, Action.LEFT_CLICK_BLOCK);
		} else {
			return List.of(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK);
		}
	}

}
