package net.siegerpg.siege.core.skills;

import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class SkillTree {

	private static Skill root;

	static {
		// Here you initialize all the skills to create the tree
		// Remember to set the root to something, so that we can find skills with a specific name
	}

	/**
	 * Gets a skill from a function
	 *
	 * @param lambda The predicate will run for each skill until it returns true. Once it returns true that skill will be returned
	 *
	 * @return The skill for which the lambda returned true
	 */
	@Nullable
	public static Skill getSkillFromFunction(Predicate< Skill > lambda) {

		return getSkillWithNameFromChildren(root, lambda);
	}

	@Nullable
	private static Skill getSkillWithNameFromChildren(Skill skill, Predicate< Skill > lambda) {

		if (lambda.test(skill))
			return skill;
		for (
				Skill child :
				skill.getChildren()
		) {
			Skill result = getSkillWithNameFromChildren(child, lambda);
			if (result != null)
				return result;
		}
		return null;
	}

}
