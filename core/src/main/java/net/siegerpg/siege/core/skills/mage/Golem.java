package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Golem extends Skill {

	final int initCooldown = 45 * 1000;
	final int initManaCost = 300;
	final int initGoldCost = 10000;
	final double healthMulti = 5.00;
	final double damageMulti = 1.00;

	public Golem() {
		this.identifier = "2_C_3";
		this.skillClass = SkillClass.MAGE;
		this.name = "Golem";
		this.description = List.of("Ride and control a golem",
		                           "that knocks enemies backwards",
		                           "and has 500% of your health,",
		                           "and 100% of your strength");
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

		return List.of("Ride and control a golem",
		               "that knocks enemies backwards",
		               "and has "+(getHealthMulti(level) * 100)+"% of your health,",
		               "and "+(getDamageMulti(level) * 100)+"% of your strength");
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {
		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.015));
	}

	@Override
	public int getGoldCost(int level) {
		return (int) (this.initGoldCost * level * 2.0);
	}

	public double getHealthMulti(int level) {
		return Utils.round(((this.healthMulti) + ((level - 1) * 0.1)), 2);
	}
	public double getDamageMulti(int level) {
		return Utils.round(((this.damageMulti) + ((level - 1) * 0.05)), 2);
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
