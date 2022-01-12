package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Cryogenesis extends Skill {

	final int initCooldown = 60 * 1000;
	final int initManaCost = 200;
	final int initGoldCost = 5000;
	final double manaMulti = 0.05;
	final double healthMulti = 0.05;

	private final String identifier = "2_A_5";
	public final SkillClass skillClass = SkillClass.MAGE;
	private final String name = "Cryogenesis";
	private final List< String > description =
			List.of("Lose movement and eyesight",
			        "for 10 seconds, then gain 20",
			        "seconds of +10% mana regen/sec,",
			        "+10% health/sec, and fill mana.");
	@Override
	public String getIdentifier() {
		return this.identifier;
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

		return List.of("Lose movement and eyesight",
		               "for 10 seconds, then gain 20",
		               "seconds of +"+((1-getManaMulti(level)) * 100)+"% mana regen/sec,",
		               "+"+((1-getHealthMulti(level)) * 100)+"% health/sec, and fill mana.");
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
		return (int) (this.initGoldCost * level * 2.0);
	}

	public double getHealthMulti(int level) {
		return this.healthMulti + ((level-1) * 0.015);
	}
	public double getManaMulti(int level) {
		return this.manaMulti + ((level-1) * 0.015);
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
