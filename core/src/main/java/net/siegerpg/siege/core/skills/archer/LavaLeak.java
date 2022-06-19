package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class LavaLeak extends Skill {

	final int initCooldown = 120 * 1000;
	final int initManaCost = 250;
	final int initGoldCost = 10000;
	final int healAmt = 5; //tier of poison to effect targets by
	final int bubbleSize = 10; //time the sphere lasts for
	final int duration = 60; //time the sphere lasts for

	public LavaLeak() {
		this.identifier = "3_B_1";
		this.skillClass = SkillClass.ARCHER;
		this.name = "Lava Leak";
		this.description = List.of(
				"A 10 block diameter sphere of flames",
				"form where your next arrow lands,",
				"burning all mobs and healing you",
				"for +5 HP/sec for each mob inside",
				"lasts for 60 seconds"
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
				"A "+getBubbleSize(level)+" block diameter sphere of flames",
				"form where your next arrow lands,",
				"burning all mobs and healing you",
				"for +"+getHealAmt(level)+" HP/sec for each mob inside",
				"lasts for "+getDuration(level)+" seconds"
		              );
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

	public int getHealAmt(int level) {

		return (int) ((this.healAmt) + Math.floor((level - 1) * 0.5));
	}

	public double getDuration(int level) {

		return (this.duration) + ((level - 1) * 2);
	}

	public double getBubbleSize(int level) {

		return (this.bubbleSize) + (level - 1);
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
