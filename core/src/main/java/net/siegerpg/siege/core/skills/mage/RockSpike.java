package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class RockSpike extends Skill {

	final int initCooldown = 20 * 1000;
	final int initManaCost = 100;
	final int initGoldCost = 3000;
	final double damageMulti = 2.0;

	private final String identifier = "2_B_1";
	public final SkillClass skillClass = SkillClass.MAGE;
	private final String name = "Rock Spike";
	private final List< String > description =
			List.of("Erupt a spike from the ground,",
			        "immobilizing the targets inside",
			        "the spike for 3 seconds and",
			        "dealing +100% damage. Deals +200%",
			        "if the spike is made from earth.");


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

		return List.of("Erupt a spike from the ground,",
		               "immobilizing the targets inside",
		               "the spike for 3 seconds and",
		               "dealing +"+((getDamageMulti(level, false) - 1) * 100)+"% damage. Deals +"+((getDamageMulti(level, true) - 1) * 100)+"%",
		               "if the spike is made from earth.");
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

	public double getDamageMulti(int level, boolean onEarth) {
		if (onEarth) return (this.damageMulti + 1.0) + ((level-1) * 0.025);
		return this.damageMulti + ((level-1) * 0.05);
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
