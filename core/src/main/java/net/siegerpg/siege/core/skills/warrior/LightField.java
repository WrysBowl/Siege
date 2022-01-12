package net.siegerpg.siege.core.skills.warrior;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.skills.Skill;
import net.siegerpg.siege.core.skills.SkillClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public class LightField extends Skill {

	final int initCooldown = 30 * 1000;
	final int initManaCost = 100;
	final int initGoldCost = 5000;
	final double manaMulti = 1.05;

	private final String identifier = "3_A_2";
	private final SkillClass skillClass = SkillClass.WARRIOR;
	private final String name = "Light Field";
	private final List< String > description =
			List.of("Enemies standing in this",
			        "circle take 10% of your",
			        "damage every second.",
			        "Allies gain +5% mana/second.",
			        "Lasts 5 seconds.");
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

		return List.of("Enemies standing in this",
		               "circle take 10% of your",
		               "damage every second.",
		               "Allies gain +"+((getManaMulti(level) - 1) * 100)+"% mana/second.",
		               "Lasts 5 seconds.");
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

	public double getManaMulti(int level) {
		return Utils.round(((this.manaMulti) + ((level - 1) * 0.01)), 2);
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
