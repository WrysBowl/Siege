package net.siegerpg.siege.core.skills;

import net.siegerpg.siege.core.miscellaneous.cache.PlayerData;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Skill {

	/**
	 * The skill's identifier, should never change (unless you want people to lose skill progress)
	 */
	private String identifier;

	public SkillClass skillClass;


	/**
	 * The identifier used to serialize/deserialize the skill status
	 *
	 * @return
	 */
	public String getIdentifier() {

		return String.format("%s.%s", skillClass.getId(), identifier);
	}


	/**
	 * The skill's name
	 */
	private String name;

	/**
	 * The skill returned to the player (should not be used to identify the skill, use getName() instead)
	 *
	 * @param level
	 *
	 * @return
	 */
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
	public List< String > getDescription() {

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
	private final List< Skill > children = new ArrayList<>();

	/**
	 * Adds multiple children to the children of this skill
	 */
	public void addChildren(List< Skill > children) {

		children.forEach(child -> child.setParent(this));
		this.children.addAll(children);
	}


	/**
	 * Adds a child to the children of this skill
	 */
	public Skill addChild(Skill child) {

		child.setParent(this);
		this.children.add(child);
		return child;
	}

	/**
	 * Gets the list of children of the skill
	 *
	 * @return The children of this skill
	 */
	@NotNull
	public List< Skill > getChildren() {

		return Collections.unmodifiableList(this.children);
	}

	public void setParent(@Nullable Skill parent) {

		this.parent = parent;
	}

	@Nullable
	public Skill getParent() {

		return this.parent;
	}

	/**
	 * Based on the level, how long the skill cooldown should last
	 *
	 * @param level The skill level
	 *
	 * @return The cooldown. We use the Duration class since that way it can be used with more than just ticks (and because using an int doesn't represent a cooldwon well)
	 */
	abstract public Duration getCooldown(int level);

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
	 * Triggers the skill
	 * This may do something as soon as it's called or delayed, it's up to the skill implementation
	 * Note #1: This checks if the skill is unlocked.
	 * Note #2: You should call this method externally, only use the trigger(player, level) if you want to bypass level checking
	 * Note #3: You should only @Override the method with trigger(player, level). Only override this in case you want to modify level checking.
	 *
	 * @param player The player that triggered the skill
	 *
	 * @return Whether the skill execution succeded.
	 */
	public boolean trigger(@NotNull Player player) {

		Integer skillLevel = SkillData.getSkillLevel(player, this);
		if (skillLevel == null || skillLevel < 1) return false;
		return trigger(player, skillLevel);
	}

	/**
	 * Triggers the skill
	 * This may do something as soon as it's called or delayed, it's up to the skill implementation
	 * Note: This does not check if the skill is unlocked
	 *
	 * @param player The player that triggered the skill
	 * @param level  The skill level the player has
	 *
	 * @return Whether the skill execution succeded.
	 */
	public boolean trigger(@NotNull Player player, int level) {

		// Checks if the skill is still in cooldown

		Instant now = Instant.now();
		Instant resetTime = SkillCooldown.getResetTime(player.getUniqueId(), this);
		if (resetTime != null && now.isBefore(resetTime)) {
			//TODO: Tell them the skill is on cooldown.
			return false;
		}
		// Checks if the player has enough mana
		double manaCost = getManaCost(level);
		Double playerMana = PlayerData.playerMana.get(player);
		if (playerMana == null || playerMana < manaCost) {
			//TODO: Tell them they don't have enough mana.
			return false;
		}
		// Removes the mana from the user
		PlayerData.playerMana.put(player, playerMana - manaCost);
		// After here you should only put stuff that should be run for every skill trigger
		return true;
	}

	/**
	 * Marks the skill as having been deactivated.
	 *
	 * @param player The player that triggered the skill
	 * @param level  The skill level the player has
	 */
	public void triggerEnd(@NotNull Player player, int level) {

		// Removes the skill from the list of active skills
		ActiveSkillData.removeFromActiveSkills(player, this);

		// Sets the cooldown
		SkillCooldown.setResetTime(player, this, Instant
				.now()
				.plus(getCooldown(level)));
		// After here you should only put stuff that should be run for every skill trigger end
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
