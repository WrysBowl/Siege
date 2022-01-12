package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Lunge extends Skill {

	final int initCooldown = 20 * 1000;
	final int initManaCost = 50;
	final int initGoldCost = 3000;
	final double damageMulti = 1.5;

	private final String identifier = "1_A_2";
	public final SkillClass skillClass = SkillClass.WARRIOR;
	private final String name = "Slash";
	private final List< String > description =
			List.of("Leap forwards dealing +50%",
			        "damage to enemies in the way.",
			        "If enemy is weakened deal +75%");


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

		return List.of("Leap forwards dealing +"+((getDamageMulti(level, false) - 1) * 100)+"%",
		               "damage to enemies in the way.",
		               "If enemy is weakened deal +"+((getDamageMulti(level, true) - 1) * 100)+"%");
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

	public double getDamageMulti(int level, boolean weakened) {
		if (weakened) return Utils.round(((this.damageMulti + 0.25) + ((level-1) * 0.025)), 2);
		return Utils.round(((this.damageMulti) + ((level-1) * 0.025)), 2);
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
