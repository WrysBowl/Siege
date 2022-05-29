package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Invigorate extends Skill {

	final int initCooldown = 45 * 1000;
	final int initManaCost = 150;
	final int initGoldCost = 5000;
	final double manaMulti = 1.2;
	final int duration = 10;

	public Invigorate() {
		this.identifier = "1_A_2";
		this.skillClass = SkillClass.MAGE;
		this.name = "Invigorate";
		this.description = List.of("Allies in 10 meters are",
		                           "effected with haste for",
		                           "10 seconds and increased",
		                           "+20% of mana. If standing",
		                           "on earth type blocks",
		                           "regeneration is given",
		                           "for 10 seconds.");
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

		return List.of("Allies in 10 meters are",
		               "effected with haste for",
		               getDuration(level)+" seconds and increased",
		               "+"+((getManaMulti(level) - 1) * 100)+"% of mana. If standing",
		               "on earth type blocks",
		               "regeneration is given",
		               "for "+getDuration(level)+" seconds.");
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
		return (int) (this.initGoldCost * level * 2.5);
	}

	public double getManaMulti(int level) {
		return Utils.round(((this.manaMulti) + ((level - 1) * 0.025)), 2);
	}
	public double getDuration(int level) {
		return (this.duration) + (level-1);
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
