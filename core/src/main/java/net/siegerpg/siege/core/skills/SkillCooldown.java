package net.siegerpg.siege.core.skills;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.HashMap;
import java.util.UUID;

public class SkillCooldown {

	public static HashMap< UUID, HashMap< String, Instant > > cooldown = new HashMap();

	/**
	 * Gets when the time will reset
	 *
	 * @param playerID  The uuid of the player
	 * @param skillName The name of the skill
	 *
	 * @return The instant when the skill will be usable again
	 */
	@Nullable
	public static Instant getResetTime(@NotNull UUID playerID, @NotNull Skill skill) {

		HashMap< String, Instant > playerData = cooldown.get(playerID);
		if (playerData != null)
			return playerData.get(skill.getIdentifier());
		return null;
	}

	/**
	 * Sets when the skill will be usable again
	 *
	 * @param playerID  The uuid of the player
	 * @param skill     The skill
	 * @param resetTime The reset time
	 */
	public static void setResetTime(UUID playerID, @NotNull Skill skill, @NotNull Instant resetTime) {

		var data = cooldown.computeIfAbsent(playerID, k -> new HashMap<>());
		data.put(skill.getIdentifier(), resetTime);
		cooldown.put(playerID, data);
	}

}
