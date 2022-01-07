package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class BloodWork extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 75;
	final int initGoldCost = 3500;
	final double bleedPercent = 0.75;

	private final String identifier = "2_B_2";
	private final SkillClass skillClass = SkillClass.WARRIOR;
	private final String name = "Blood Work";
	private final List< String > description =
			List.of("Damage a target within",
			        "2 meters on next hit to",
			        "inflict bleed effect.",
			        "Target loses 25% health,",
			        "or 40% if weakened,",
			        "over 10 seconds.");

	@Override
	public String getName(int level) {

		return this.name + " Lvl. " + level;
	}

	@Override
	public List< String > getDescription(int level) {

		return List.of("Damage a target within",
		               "2 meters on next hit to",
		               "inflict bleed effect.",
		               "Target loses "+(1-(getDamageMulti(level, false)) * 100)+"% health,",
		               "or 40% if weakened,",
		               "over 10 seconds.");
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

	public double getDamageMulti(int level, boolean weakened) {
		if (weakened) return Utils.round(((this.bleedPercent - 0.15) - ((level - 1) * 0.025)), 2);
		return Utils.round(((this.bleedPercent) - ((level - 1) * 0.025)), 2);
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
