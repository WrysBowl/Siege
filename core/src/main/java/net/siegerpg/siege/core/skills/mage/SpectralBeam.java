package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class SpectralBeam extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 150;
	final int initGoldCost = 5000;
	final double damageMulti = 2.00;

	private final String identifier = "2_C_5";
	public final SkillClass skillClass = SkillClass.MAGE;
	private final String name = "Spectral Beam";
	private final List< String > description =
			List.of("Shoot a beam, stunning all",
			        "mobs in it's way for 3 seconds.",
			        "Deals +100% strength and",
			        "summon a zombie puppet.");


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

		return List.of("Shoot a beam, stunning all",
		               "mobs in it's way for 3 seconds.",
		               "Deals +"+((getDamageMulti(level)-1) * 100)+"% strength and",
		               "summon a zombie puppet.");
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

	public double getDamageMulti(int level) {
		return Utils.round(((this.damageMulti) + ((level - 1) * 0.025)), 2);
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
