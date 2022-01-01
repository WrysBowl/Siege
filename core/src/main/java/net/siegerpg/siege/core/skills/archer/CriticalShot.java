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
		//check cooldown
		//set cooldown
		//Critical shot needs to set the arrow's damage and reset the damage multi
		//Create a skill listener class to listen when any event is done for the skill to be used up
		//Skills wait in a cached arraylist of skills
		//Each skill cached will have their actionCheck method used to see if the event is valid for the skill
		//If the skill can be used in the event, then the action method will be called and the skill will be removed within the method
		return true;
	}

}
