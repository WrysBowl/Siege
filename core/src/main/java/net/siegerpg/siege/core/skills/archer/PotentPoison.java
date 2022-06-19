package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class PotentPoison extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 100;
	final int initGoldCost = 3000;
	final int poisonTier = 3; //tier of poison to effect targets by
	final int duration = 5; //time the sphere lasts for

	public PotentPoison() {
		this.identifier = "3_A_3";
		this.skillClass = SkillClass.ARCHER;
		this.name = "Potent Poison";
		this.description = List.of(
				"A sphere of poison forms",
				"where your next arrow lands,",
				"effecting targets with poison III.",
				"Sphere lasts 5 seconds"
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
				"A sphere of poison forms",
				"where your next arrow lands,",
				"effecting targets with poison "+getPoisonTier(level),
				"Sphere lasts "+getDuration(level)+" seconds"
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

		return (int) (this.initGoldCost * level * 3.0);
	}

	public int getPoisonTier(int level) {

		return (int) ((this.poisonTier) + Math.floor((level-1) * 0.5));
	}

	public double getDuration(int level) {

		return (this.duration) + (level-1);
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
