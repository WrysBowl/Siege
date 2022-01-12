package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class ToxicSpores extends Skill {

	final int initCooldown = 60 * 1000;
	final int initManaCost = 200;
	final int initGoldCost = 5000;
	final int poisonTier = 1; //tier of poison effect
	final int duration = 30; //duration of effect
	private final String identifier = "3_A_1";
	public final SkillClass skillClass = SkillClass.ARCHER;
	private final String name = "Toxic Spores";
	private final List< String > description =
			List.of(
					"The hit target is effected with",
					"poison I and spreads the effect to",
					"other mobs for 30 seconds"
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
				"The hit target is effected with",
				"poison "+getPoisonTier(level)+" and spreads the effect to",
				"other mobs for "+getDuration(level)+" seconds"
		              );
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {

		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.03));
	}

	@Override
	public int getGoldCost(int level) {

		return (int) (this.initGoldCost * level * 5.0);
	}

	public int getPoisonTier(int level) {

		return (int) ((this.poisonTier) + Math.floor(this.poisonTier * (level-1) * 0.5));
	}

	public double getDuration(int level) {

		return (this.duration) + ((level-1) * 2);
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
