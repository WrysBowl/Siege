package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Hailstorm extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 150;
	final int initGoldCost = 2500;
	final double damageMulti = 1.0;

	public Hailstorm() {
		this.identifier = "2_A_4";
		this.skillClass = SkillClass.MAGE;
		this.name = "Hailstorm";
		this.description = List.of("Ice bolts rain from the",
		                           "sky, striking enemies in",
		                           "a concentrated area. If",
		                           "damaged targets are slowed,",
		                           "deal +50% more damage.");
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

		return List.of("Ice bolts rain from the",
		               "sky, striking enemies in",
		               "a concentrated area. If",
		               "damaged targets are slowed,",
		               "deal +"+((getDamageMulti(level, true)-1) * 100)+"% more damage.");
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

	public double getDamageMulti(int level, boolean slowed) {
		if (slowed) return (this.damageMulti + 0.5) + ((level-1) * 0.05);
		return this.damageMulti + ((level-1) * 0.05);
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
