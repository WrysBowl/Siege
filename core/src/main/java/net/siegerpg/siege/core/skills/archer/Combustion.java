package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Combustion extends Skill {

	final int initCooldown = 20 * 1000;
	final int initManaCost = 50;
	final int initGoldCost = 2500;
	final double damageMulti = 1.5; //percentage to remove health by (1-0.1)*health = newHealth
	private final String identifier = "3_B_3";
	private final SkillClass skillClass = SkillClass.ARCHER;
	private final String name = "Combustion";
	private final List< String > description =
			List.of(
					"This arrow will light the ground",
					"on fire and explode on impact.",
					"If player has Fireman skill active",
					"explosion damage increases by 50%"
			       );

	@Override
	public String getName(int level) {

		return this.name + " Lvl. " + level;
	}

	@Override
	public List< String > getDescription(int level) {

		return List.of(
				"This arrow will light the ground",
				"on fire and explode on impact.",
				"If player has Fireman skill active",
				"explosion damage increases by "+((getDamageMulti(level)-1) * 100)+"%"
		              );
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {

		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.05));
	}

	@Override
	public int getGoldCost(int level) {

		return (int) (this.initGoldCost * level * 4.0);
	}

	public double getDamageMulti(int level) {

		return (this.damageMulti) + ((level-1) * 0.1);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		return super.trigger(player, level);

		// Handling of the skill goes here
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
