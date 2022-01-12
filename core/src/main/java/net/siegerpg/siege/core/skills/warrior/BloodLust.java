package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class BloodLust extends Skill {

	final int initCooldown = 60 * 1000;
	final int initManaCost = 100;
	final int initGoldCost = 5000;
	final double healMulti = 0.75;

	private final String identifier = "3_B_2";
	private final SkillClass skillClass = SkillClass.WARRIOR;
	private final String name = "Blood Lust";
	private final List< String > description =
			List.of("Heal yourself for 25% of",
			        "the damage you deal for",
			        "10 seconds. If enemy is",
			        "weakened heal for 50%.");
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

		return List.of("Heal yourself for "+(1-(getHealMulti(level, false)) * 100)+"% of",
		               "the damage you deal for",
		               "10 seconds. If enemy is",
		               "weakened heal for "+(1-(getHealMulti(level, true)) * 100)+"%.");
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
		return (int) (this.initGoldCost * level * 5.0);
	}

	public double getHealMulti(int level, boolean weakened) {
		if (weakened) return Utils.round(((this.healMulti - 0.25) - ((level - 1) * 0.025)), 2);
		return Utils.round(((this.healMulti) - ((level - 1) * 0.025)), 2);
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
