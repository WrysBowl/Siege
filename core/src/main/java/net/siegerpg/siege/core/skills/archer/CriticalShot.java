package net.siegerpg.siege.core.skills.archer;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class CriticalShot extends Skill {

	private final String identifier = "criticalshot";
	private final SkillClass skillClass = SkillClass.ARCHER;
	private final String name = "Critical Shot";
	private final List< String > description = List.of("+50% STR next shot");
	private final Skill parent = null;
	private final List< Skill > children = null;
	private final int initCooldown = 10 * 1000;
	private final int initManaCost = 50;
	private final int initGoldCost = 1000;
	private final double damageMulti = 0.5;


	@Override
	public String getName(int level) {

		return this.name + " Lvl. " + level;
	}

	@Override
	public List< String > getDescription(int level) {

		return List.of("+" + getDamageMulti(level) + "% STR next shot");
	}

	@Override
	public Skill getParent() {

		return this.parent;
	}

	@NotNull
	@Override
	public List< Skill > getChildren() {

		return this.children;
	}

	@Override
	public Duration getCooldown(int level) {

		int time = (int) (this.initCooldown - Math.ceil(this.initCooldown * level * 0.01));
		int limit = this.initCooldown / 2;
		if (time < limit) time = limit;
		return Duration.ofMillis(time);
	}

	@Override
	public double getManaCost(int level) {

		int mana = (int) (this.initManaCost - Math.ceil(this.initManaCost * level * 0.005));
		int limit = this.initManaCost / 2;
		if (mana < limit) mana = limit;
		return mana;
	}

	public double getDamageMulti(int level) {

		double multi = (this.damageMulti) + (level * 0.01);
		return damageMulti;
	}

	@Override
	public int getGoldCost(int level) {

		return (int) (this.initGoldCost * level * 2.5);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if (!super.trigger(player, level)) return false;

		// Handling of the skill goes here


		return true;
	}

}
