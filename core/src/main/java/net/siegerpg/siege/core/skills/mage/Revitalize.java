package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Revitalize extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 150;
	final int initGoldCost = 5000;
	final double manaMulti = 0.05;
	final double healthMulti = 0.05;

	public Revitalize() {
		this.identifier = "2_B_2";
		this.skillClass = SkillClass.MAGE;
		this.name = "Revitalize";
		this.description = List.of("Create a circle for allies",
		                           "that heal +5% HP/sec and",
		                           "+5% Mana/sec for 10 seconds.",
		                           "If circle is on earth material,",
		                           "increase duration to 20 seconds.");
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

		return List.of("Create a circle for allies",
		               "that heal +"+((getHealthMulti(level) + 1) * 100)+"% HP/sec and",
		               "+"+((getManaMulti(level) + 1) * 100)+"% Mana/sec for 10 seconds.",
		               "If circle is on earth material,",
		               "increase duration to 20 seconds.");
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
		return (int) (this.initGoldCost * level * 3.0);
	}

	public double getHealthMulti(int level) {
		return this.healthMulti + ((level-1) * 0.015);
	}
	public double getManaMulti(int level) {
		return this.manaMulti + ((level-1) * 0.015);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if(!super.trigger(player, level)) return false;


		// Handling of the skill goes here
		return true;
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
