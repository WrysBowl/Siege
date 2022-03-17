package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class IceBolt extends Skill {

	final int initCooldown = 10 * 1000;
	final int initManaCost = 50;
	final int initGoldCost = 2500;
	final double damageMulti = 1.25;

	public IceBolt() {
		this.identifier = "1_A_1";
		this.skillClass = SkillClass.MAGE;
		this.name = "Ice Bolt";
		this.description = List.of("Fires an ice missile",
		                           "towards an enemy that",
		                           "slows them by 20% for",
		                           "3 seconds and deals",
		                           "+25% strength damage.");
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

		return List.of("Fires an ice missile",
		               "towards an enemy that",
		               "slows them by 20% for",
		               "3 seconds and deals",
		               "+"+((getDamageMulti(level)-1) * 100)+"% strength damage.");
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
		return (int) (this.initGoldCost * level * 4.0);
	}

	public double getDamageMulti(int level) {
		return Utils.round(((this.damageMulti) + ((level - 1) * 0.025)), 2);
	}


	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if(!super.trigger(player, level)) return false;

		// Handling of the skill goes here

		//triggerEnd(player, level) call for skill's end.
		return true;
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
