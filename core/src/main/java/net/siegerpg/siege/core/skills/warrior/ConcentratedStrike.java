package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class ConcentratedStrike extends Skill {

	final int initCooldown = 20 * 1000;
	final int initManaCost = 50;
	final int initGoldCost = 3000;
	final double manaMulti = 1.2;

	private final String identifier = "3_A_1";
	public final SkillClass skillClass = SkillClass.WARRIOR;
	private final String name = "Concentrated Strike";
	private final List< String > description =
			List.of("Hit the enemy for +100% damage",
			        "and give +20% mana to allies, or",
			        "30% if weakened within 10 meters.");


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

		return List.of("Hit the enemy for +100% damage",
		               "and give +"+((getManaMulti(level, false) - 1) * 100)+"% mana to allies, or",
		               ((getManaMulti(level, true) - 1) * 100)+"% if weakened within 10 meters.");
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

	public double getManaMulti(int level, boolean weakened) {
		if (weakened) return Utils.round(((this.manaMulti + 0.1) + ((level - 1) * 0.01)), 2);
		return Utils.round(((this.manaMulti) + ((level - 1) * 0.01)), 2);
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
