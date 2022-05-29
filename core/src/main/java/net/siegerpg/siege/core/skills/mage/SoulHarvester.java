package net.siegerpg.siege.core.skills.mage;

import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class SoulHarvester extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 150;
	final int initGoldCost = 5000;
	final double manaHealthMulti = 0.25;

	public SoulHarvester() {
		this.identifier = "2_B_3";
		this.skillClass = SkillClass.MAGE;
		this.name = "Soul Harvester";
		this.description = List.of("Create a circle that saps",
		                           "the soul of all enemies and",
		                           "allies that died in it. Heals",
		                           "for +25% HP and mana each soul.");
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

		return List.of("Create a circle that saps",
		               "the soul of all enemies and",
		               "allies that died in it. Heals",
		               "for +"+((getHealthManaMulti(level) + 1) * 100)+"% HP and mana each soul.");
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
		return (int) (this.initGoldCost * level * 5.0);
	}

	public double getHealthManaMulti(int level) {
		return this.manaHealthMulti + ((level-1) * 0.015);
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
