package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class SerpentineArrow extends Skill {

	final int initCooldown = 20 * 1000;
	final int initManaCost = 50;
	final int initGoldCost = 2500;
	final int bounceDuration = 5; //amount of time the arrow bounces around in seconds

	public SerpentineArrow() {
		this.identifier = "2_B_1";
		this.skillClass = SkillClass.ARCHER;
		this.name = "Serpentine Arrow";
		this.description = List.of(
				"Your next arrow will bounce",
				"to a new enemy for 5 seconds"
		                          );
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

		return List.of(
				"Your next arrow will bounce",
				"to a new enemy for " + getBounceDuration(level) + " seconds"
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

		return (int) (this.initGoldCost * level * 5.0);
	}

	public int getBounceDuration(int level) {

		return (int) (this.bounceDuration + Math.ceil(this.bounceDuration * (level-1) * 0.2));
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
