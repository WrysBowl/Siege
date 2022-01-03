package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class FlamingArrow extends Skill {

	private final String identifier = "2_B_2";
	private final SkillClass skillClass = SkillClass.ARCHER;
	private final String name = "Flaming Arrow";
	private final List< String > description =
			List.of(
					"Your next arrow will burn nearby",
					"mobs where it lands. Deals +50% damage",
					" if you or your enemy is burning."
			       );
	private final Skill parent = new CriticalShot();
	private final List< Skill > children = null;
	final int initCooldown = 25 * 1000;
	final int initManaCost = 40;
	final int initGoldCost = 2500;
	final double damageMulti = 1.0; //amount of time the arrow bounces around in seconds


	@Override
	public String getName(int level) {

		return this.name + " Lvl. " + level;
	}

	@Override
	public List< String > getDescription(int level) {

		return List.of(
				"Your next arrow will burn nearby",
				"mobs where it lands. Deals +"+((getDamageMulti(level, true)-1)*100)+"% damage",
				" if you or your enemy is burning."
		              );
	}

	@Override
	public Skill getParent() {

		return this.parent;
	}

	@NotNull
	@Override
	public List< Skill > getChildren() {

		return this.children;
	}

	@Override
	public Duration getCooldown(int level) {

		int time = (int) (this.initCooldown + Math.ceil(this.initCooldown * level * 0.03));
		return Duration.ofMillis(time);
	}

	@Override
	public double getManaCost(int level) {

		return (int) (this.initManaCost + Math.ceil(this.initManaCost * level * 0.075));
	}


	public double getDamageMulti(int level, boolean burning) {

		if (burning) return (this.damageMulti) + (level * 0.1);
		return this.damageMulti;
	}

	@Override
	public int getGoldCost(int level) {

		return (int) (this.initGoldCost * level * 3.0);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if (!super.trigger(player, level)) return false;

		// Handling of the skill goes here


		return true;
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
