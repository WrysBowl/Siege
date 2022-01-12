package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class UndeadRevival extends Skill {

	final int initCooldown = 60 * 1000;
	final int initManaCost = 100;
	final int initGoldCost = 5000;
	final int healAmt = 10; //amount to multiply damage by
	private final String identifier = "3_A_2";
	private final SkillClass skillClass = SkillClass.ARCHER;
	private final String name = "Undead Revival";
	private final List< String > description =
			List.of(
					"Heals 10 HP/sec, but poison heals",
					"an additional 10 HP/sec for every",
					"tier you are effected by for 30 seconds"
			       );
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

		return List.of(
				"Heals "+getHealAmt(level, false)+" HP/sec, but poison heals",
				"an additional "+getHealAmt(level, true)+" HP/sec for every",
				"tier you are effected by for 30 seconds"
		              );
	}


	@Override
	public Duration getCooldown(int level) {
		return Duration.ofMillis(initCooldown);
	}

	@Override
	public int getManaCost(int level) {

		return (int) (this.initManaCost + Math.ceil(this.initManaCost * (level-1) * 0.07));
	}

	@Override
	public int getGoldCost(int level) {

		return (int) (this.initGoldCost * level * 3.0);
	}

	public int getHealAmt(int level, boolean poisoned) {

		if (poisoned) return (this.healAmt) + (level-1);
		return this.healAmt;
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
