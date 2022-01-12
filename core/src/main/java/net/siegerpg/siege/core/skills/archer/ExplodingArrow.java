package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class ExplodingArrow extends Skill {

	final int initCooldown = 20 * 1000;
	final int initManaCost = 60;
	final int initGoldCost = 3500;
	final double damageMulti = 1.25; //percentage to remove health by (1-0.1)*health = newHealth
	final double radius = 2.0; //percentage to remove health by (1-0.1)*health = newHealth
	private final String identifier = "3_B_2";
	private final SkillClass skillClass = SkillClass.ARCHER;
	private final String name = "Exploding Arrow";
	private final List< String > description =
			List.of(
					"Shoots an explosive arrow.",
					"Deals +25% of strength, or +50%",
					"if affected targets are burning.",
					"Explosive radius reaches 2 blocks"
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
				"Shoots an explosive arrow.",
				"Deals +25% of strength, or +"+((getDamageMulti(level, true)-1) * 100)+"%",
				"if affected targets are burning.",
				"Explosive radius reaches "+getRadius(level)+" blocks"
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

	public double getDamageMulti(int level, boolean burning) {

		if (burning) return (this.damageMulti) + ((level-1) * 0.05);
		return this.damageMulti;
	}

	public double getRadius(int level) {

		return (this.radius) + ((level-1) * 0.5);
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
