package net.siegerpg.siege.core.skills;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class SkillTree {

	private static Skill root;

	static {
		// Here you initialize all the skills to create the tree
		// Remember to set the root to something, so that we can find skills with a specific name
	}

	@Nullable
	public static Skill getSkillWithName(String skillName) {

		return getSkillWithNameFromChildren(root, skillName);
	}

	@Nullable
	private static Skill getSkillWithNameFromChildren(Skill skill, String skillName) {

		if (Objects.equals(skill.getName(), skillName))
			return skill;
		for (
				Skill child :
				skill.getChildren()
		) {
			Skill result = getSkillWithNameFromChildren(child, skillName);
			if (result != null)
				return result;
		}
		return null;
	}

}
