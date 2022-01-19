package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Earthquake extends Skill {

	final int initCooldown = 45 * 1000;
	final int initManaCost = 150;
	final int initGoldCost = 5000;
	final double damageMulti = 2.0;

	public Earthquake() {
		this.identifier = "2_B_4";
		this.skillClass = SkillClass.MAGE;
		this.name = "Earthquake";
		this.description = List.of("Erupt the ground with spikes.",
		                           "If hit, mobs will be damaged",
		                           "for +100% strength. Leaves",
		                           "dirt material for 30 seconds.");
	}

	@Override
	public List< String > getDescription() {
		return this.description;
	}
	@Override
	public String getName(int level) {

		return this.name + " Lvl. " + level;
	}

	@Override
	public List< String > getDescription(int level) {

		return List.of("Erupt the ground with spikes.",
		               "If hit, mobs will be damaged",
		               "for +"+((getDamageMulti(level) - 1) * 100)+"% strength. Leaves",
		               "dirt material for 30 seconds.");
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {
		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.02));
	}

	@Override
	public int getGoldCost(int level) {
		return (int) (this.initGoldCost * level * 5.0);
	}

	public double getDamageMulti(int level) {
		return this.damageMulti + ((level-1) * 0.05);
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
