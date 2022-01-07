package net.siegerpg.siege.core.skills;

import net.siegerpg.siege.core.skills.archer.*;
import net.siegerpg.siege.core.skills.warrior.*;
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
		/*
		ARCHER SKILLS
		 */
		Skill criticalShot = new CriticalShot();
		roots.add(criticalShot);
		Skill achillesHeel = new AchillesHeel();
		roots.add(achillesHeel);

		Skill poisonArrow = criticalShot.addChild(new PoisonArrow());
		Skill piercingArrow = poisonArrow.addChild(new PiercingArrow());
		Skill venomousAura = poisonArrow.addChild(new VenomousAura());

		Skill flamingArrow = criticalShot.addChild(new FlamingArrow());
		Skill serpentineArrow = flamingArrow.addChild(new SerpentineArrow());
		Skill fireman = flamingArrow.addChild(new Fireman());

		Skill toxicSpores = venomousAura.addChild(new ToxicSpores());
		Skill undeadRevival = venomousAura.addChild(new UndeadRevival());
		Skill potentPoison = venomousAura.addChild(new PotentPoison());

		Skill lavaLeak = fireman.addChild(new LavaLeak());
		Skill explodingArrow = fireman.addChild(new ExplodingArrow());
		Skill combustion = fireman.addChild(new Combustion());

		/*
		WARRIOR SKILLS
		 */
		Skill slash = new Slash();
		roots.add(slash);
		Skill lunge = new Lunge();
		roots.add(lunge);

		Skill taunt = slash.addChild(new Taunt());
		Skill armory = taunt.addChild(new Armory());
		Skill quakeCharge = taunt.addChild(new QuakeCharge());
		Skill selflessDefense = taunt.addChild(new SelflessDefense());

		Skill doubleStrike = slash.addChild(new DoubleStrike());
		Skill warCry = doubleStrike.addChild(new WarCry());
		Skill bloodWork = doubleStrike.addChild(new BloodWork());
		Skill parry = doubleStrike.addChild(new Parry());

		Skill concentratedStrike = selflessDefense.addChild(new ConcentratedStrike());
		Skill lightField = selflessDefense.addChild(new LightField());
		Skill divinePresence = selflessDefense.addChild(new DivinePresence());

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
