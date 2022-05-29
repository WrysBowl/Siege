package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class DemonTransformation extends Skill {

	final int initCooldown = 60 * 1000;
	final int initManaCost = 200;
	final int initGoldCost = 10000;
	final double damageMulti = 4.00;

	public DemonTransformation() {
		this.identifier = "2_C_4";
		this.skillClass = SkillClass.MAGE;
		this.name = "Demon Transformation";
		this.description = List.of("Transform into a demon",
		                           "for 30 seconds, and deal",
		                           "+300% strength on each hit.",
		                           "Each mob killed becomes",
		                           "a zombie puppet.");
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

		return List.of("Transform into a demon",
		               "for 30 seconds, and deal",
		               "+"+((getDamageMulti(level)-1) * 100)+"% strength on each hit.",
		               "Each mob killed becomes",
		               "a zombie puppet.");
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
		return (int) (this.initGoldCost * level * 2.5);
	}

	public double getDamageMulti(int level) {
		return Utils.round(((this.damageMulti) + ((level - 1) * 0.1)), 2);
	}

	@Override
	public boolean trigger(@NotNull Player player, int level) {
		// First we check if the cooldown and mana are respected (we run the code common to all skills)
		// If the trigger() method returns false it means that the execution was not successful (for example the cooldown wasn't finished) so we stop executing and return false
		if(!super.trigger(player, level)) return false;


		// Handling of the skill goes here
		return true;
	}

	@Override
	public void triggerEnd(@NotNull Player player, int level) {

		super.triggerEnd(player, level);

	}

}
