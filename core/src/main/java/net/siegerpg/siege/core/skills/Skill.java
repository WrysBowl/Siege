package net.siegerpg.siege.core.skills;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;

public abstract class Skill {

	/**
	 * The skill's name, what will be shown to the user
	 */
	private String name;

	/**
	 * The skill's description, what will be shown to the user
	 */
	protected String description;


	/**
	 * The skill's parent (this skill is a child of that skill
	 * Can be null (for the root skill)
	 */
	@Nullable
	public Skill parent;

	/**
	 * The skill's children (this skill is a parent of all those skills)
	 */
	@NotNull
	public Skill[] children = new Skill[] {};

	/**
	 * Based on the level, how long the skill cooldown should last
	 *
	 * @param level The skill level
	 *
	 * @return The duraation of the cooldown
	 */
	abstract public Duration getCooldownDuration(int level);

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

}
