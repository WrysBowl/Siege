package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class Taunt extends Skill {

	final int initCooldown = 45 * 1000;
	final int initManaCost = 150;
	final int initGoldCost = 3000;
	final int duration = 10;
	final int range = 5;

	private final String identifier = "2_A_2";
	public final SkillClass skillClass = SkillClass.WARRIOR;
	private final String name = "Taunt";
	private final List< String > description =
			List.of("Force all mobs within",
			        "5 blocks to attack you.",
			        "Weaken your attacks by 20%",
			        "for 10 seconds");
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

		return List.of("Force all mobs within",
		               getRange(level)+" blocks to attack you.",
		               "Weaken your attacks by 20%",
		               "for "+getDuration(level)+" seconds");
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

	public double getDuration(int level) {
		return (this.duration) + (level-1);
	}
	public double getRange(int level) {
		return (this.range) + (level-1);
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
