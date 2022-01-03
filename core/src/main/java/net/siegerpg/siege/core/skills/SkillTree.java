package net.siegerpg.siege.core.skills;

import net.siegerpg.siege.core.skills.archer.*;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SkillTree {

	/**
	 * We have multiple tree roots for each skill class
	 */
	private static final List< Skill > roots = new ArrayList<>();

	static {
		// The CriticalShot is the first skill of the archer tree
		Skill criticalShot = new CriticalShot();
		Skill achillesHeel = new AchillesHeel();
		roots.add(criticalShot);
		// We add the poison arrow to the skill tree
		Skill poisonArrow = criticalShot.addChild(new PoisonArrow());
		Skill piercingArrow = criticalShot.addChild(new PiercingArrow());
		Skill venomousAura = criticalShot.addChild(new VenomousAura());
		Skill serpentineArrow = criticalShot.addChild(new SerpentineArrow());
		Skill flamingArrow = criticalShot.addChild(new FlamingArrow());
		Skill fireman = criticalShot.addChild(new Fireman());

		// Now if you want to add children to poisonArrow you have to do
		// Skill someArcherSkill = poisonArrow.addChild(new SomeArcherSkill());

	}

	/**
	 * Gets a skill from a function
	 *
	 * @param lambda The predicate will run for each skill until it returns true. Once it returns true that skill will be returned
	 *
	 * @return The skill for which the lambda returned true
	 */
	@Nullable
	public static Skill getSkill(Predicate< Skill > lambda) {

		return getSkillFromChildren(roots, lambda);
	}

	/**
	 * Goes through all the skills in the list (and the children of the skills in the list, and the children of the children, ... recursively)
	 * until it finds a skill that matches the predicate
	 *
	 * @param skills The list of skills in which to search for a specific skill
	 * @param lambda The predicate will run for each skill until it returns true. Once it returns true that skill will be returned
	 *
	 * @return The skill for which the lambda returned true
	 */
	@Nullable
	private static Skill getSkillFromChildren(List< Skill > skills, Predicate< Skill > lambda) {

		for (
				Skill skill :
				skills
		) {
			if (lambda.test(skill)) {
				return skill;
			}
			Skill result = getSkillFromChildren(skill.getChildren(), lambda);
			if (result != null)
				return result;
		}
		return null;
	}

}
