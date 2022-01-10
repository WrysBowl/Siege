package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Sacrifice extends Skill {

	final int initCooldown = 60 * 1000;
	final int initManaCost = 200;
	final int initGoldCost = 5000;
	final double healthManaMulti = 0.25;

	private final String identifier = "2_C_2";
	private final SkillClass skillClass = SkillClass.MAGE;
	private final String name = "Sacrifice";
	private final List< String > description =
			List.of("All of your puppets will",
			        "take the damage dealt to",
			        "you for 15 seconds. If a",
			        "puppet is killed, gain +25%",
			        "of your mana and health.");

	@Override
	public String getName(int level) {

		return this.name + " Lvl. " + level;
	}

	@Override
	public List< String > getDescription(int level) {

		return List.of("All of your puppets will",
		               "take the damage dealt to",
		               "you for 15 seconds. If a",
		               "puppet is killed, gain +"+((getHealthManaMulti(level)+1) * 100)+"%",
		               "of your mana and health.");
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {
		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.025));
	}

	@Override
	public int getGoldCost(int level) {
		return (int) (this.initGoldCost * level * 3.0);
	}

	public double getHealthManaMulti(int level) {
		return Utils.round(((this.healthManaMulti) + ((level - 1) * 0.025)), 2);
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
