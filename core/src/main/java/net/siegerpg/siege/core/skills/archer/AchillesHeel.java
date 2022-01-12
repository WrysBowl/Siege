package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class AchillesHeel extends Skill {

	final int initCooldown = 60 * 1000;
	final int initManaCost = 60;
	final int initGoldCost = 5000;
	final int initSpeedTime = 20;
	private final String identifier = "1_A_2";
	private final SkillClass skillClass = SkillClass.ARCHER;
	private final String name = "Achilles Heel";
	private final List< String > description = List.of("Speed II for 20 seconds");
	@Override
	public String getIdentifier() {
		return this.identifier;
	}
	@Override
	public SkillClass getSkillClass() {
		return this.skillClass;
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

		return List.of("Speed II for "+getSpeedTime(level)+" seconds");
	}

	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {

		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.04));
	}

	@Override
	public int getGoldCost(int level) {

		return (int) (this.initGoldCost * level * 5.0);
	}

	//Use this method to set the duration of the speed effect
	public int getSpeedTime(int level) {

		return this.initSpeedTime + (int) Math.ceil(this.initSpeedTime * (level-1) * 0.1);
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
