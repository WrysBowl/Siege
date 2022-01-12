package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class ZombiePuppet extends Skill {

	final int initCooldown = 20 * 1000;
	final int initManaCost = 100;
	final int initGoldCost = 2500;
	final double healthMulti = 1.00;
	final double damageMulti = 1.00;

	private final String identifier = "2_C_1";
	public final SkillClass skillClass = SkillClass.MAGE;
	private final String name = "Zombie Puppet";
	private final List< String > description =
			List.of("Summon a zombie that fights for",
			        "you. Has 100% of your strength,",
			        "and 100% of your health.");


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

		return List.of("Summon a zombie that fights for",
		               "you. Has "+(getDamageMulti(level) * 100)+"% of your strength,",
		               "and "+(getHealthMulti(level) * 100)+"% of your health.");
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

	public double getHealthMulti(int level) {
		return Utils.round(((this.healthMulti) + ((level - 1) * 0.05)), 2);
	}
	public double getDamageMulti(int level) {
		return Utils.round(((this.damageMulti) + ((level - 1) * 0.05)), 2);
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
