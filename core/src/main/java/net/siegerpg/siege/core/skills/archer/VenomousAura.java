package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class VenomousAura extends Skill {

	final int initCooldown = 60 * 1000;
	final int initManaCost = 150;
	final int initGoldCost = 10000;
	final double damageMulti = 1.05; //amount to multiply damage by
	private final String identifier = "2_A_3";
	public final SkillClass skillClass = SkillClass.ARCHER;
	private final String name = "Venomous Aura";
	private final List< String > description =
			List.of(
					"Deal extra damage for every level",
					"of poison your target is effected with",
					"and poison yourself for 30 seconds"
			       );
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

		return List.of(
				"Deal +"+((getDamageMulti(level)-1)*100)+"% damage for every level",
				"of poison your target is effected with",
				"and poison yourself for 30 seconds"
		              );
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {

		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.05));
	}

	@Override
	public int getGoldCost(int level) {

		return (int) (this.initGoldCost * level * 3.0);
	}

	public double getDamageMulti(int level) {

		return (this.damageMulti) + ((level-1) * 0.01);
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
