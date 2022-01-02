package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class AchillesHeel extends Skill {

	private final String identifier = "2";
	private final SkillClass skillClass = SkillClass.ARCHER;
	private final String name = "Achilles Heel";
	private final List< String > description = List.of("Speed II for 20 seconds");
	private final Skill parent = null;
	private final List< Skill > children = null;
	final int initCooldown = 60 * 1000;
	final int initManaCost = 60;
	final int initGoldCost = 2000;
	final int initSpeedTime = 20;


	@Override
	public String getName(int level) {

		return this.name + " Lvl. " + level;
	}

	@Override
	public List< String > getDescription(int level) {

		return List.of("Speed II for 20 seconds");
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

	//Use this method to set the duration of the speed effect
	public int getSpeedTime(int level) {
		return this.initSpeedTime + (int) Math.ceil(this.initSpeedTime * level * 0.1);
	}

	@Override
	public Duration getCooldown(int level) {

		//increases by 1
		int time = (int) (this.initCooldown + Math.ceil(this.initCooldown * level * 0.005));
		return Duration.ofMillis(time);
	}

	@Override
	public double getManaCost(int level) {

		return (int) (this.initManaCost + Math.ceil(this.initManaCost * level * 0.04));
	}

	@Override
	public int getGoldCost(int level) {

		return (int) (this.initGoldCost * level * 1.5);
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
