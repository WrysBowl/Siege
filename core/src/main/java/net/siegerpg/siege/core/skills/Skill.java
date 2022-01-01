package net.siegerpg.siege.core.skills;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Skill {

	/**
	 * The skill's name, what will be shown to the user
	 */
	private String name;

	public String getName(int level) {

		return name;
	}

	/**
	 * The skill's description, what will be shown to the user
	 */
	private List< String > description;

	public List< String > getDescription(int level) {
		return description;
	}

	/**
	 * The skill's parent (this skill is a child of that skill
	 * Can be null (for the root skill)
	 */
	@Nullable
	private Skill parent = null;

	/**
	 * The skill's children (this skill is a parent of all those skills)
	 */
	@NotNull
	private List< Skill > children = new ArrayList<>();

	public void addChildren(List< Skill > children) {

		children.forEach(child -> child.setParent(this));
	}

	public void setParent(Skill parent) {

		this.parent = parent;
	}

	@Nullable
	public Skill getParent() {

		return this.parent;
	}

	@NotNull
	public List< Skill > getChildren() {

		return Collections.unmodifiableList(this.children);
	}

	/**
	 * Initial cooldown in ticks of the skill before calculating with level
	 *
	 * @return The initial cooldown in ticks
	 */
	abstract public int getInitCooldown();

	/**
	 * Initial mana cost before calculating with level
	 *
	 * @return The initial mana cost
	 */
	abstract public int getInitManaCost();

	/**
	 * Initial gold cost before calculating with level
	 *
	 * @return The initial gold cost
	 */
	abstract public int getInitGoldCost();

	/**
	 * Based on the level, how long the skill cooldown should last
	 *
	 * @param level The skill level
	 *
	 * @return The cooldown in ticks
	 */
	abstract public int getCooldown(int level);

	/**
	 * How much the skill costs to activate
	 *
	 * @param level The skill level
	 *
	 * @return The mana cost
	 */
	abstract public int getManaCost(int level);

	/**
	 * s
	 * How much the skill costs to upgrade
	 *
	 * @param level The *new* level (always current+1)
	 *
	 * @return How much gold the skill costs to upgrade
	 */
	abstract public int getGoldCost(int level);

	/**
	 * Triggers the skill (this may do something instantaneously or something delayed, we don't know)
	 *
	 * @param player The player that triggered the skill
	 * @param level  The skill level the player has
	 */
	public void trigger(@NotNull Player player, int level) {
		//TODO Here we check if the player has enough mana to run the thingy

	}

	/**
	 * Gets the root of the tree
	 *
	 * @return Returns root skill
	 */
	public Skill getRoot() {

		if (parent == null) return this;
		return parent.getRoot();
	}

}
