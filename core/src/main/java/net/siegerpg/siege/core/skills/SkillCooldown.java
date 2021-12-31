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
	public static Instant getResetTime(UUID playerID, String skillName) {

		HashMap< String, Instant > playerData = cooldown.get(playerID);
		if (playerData != null)
			return playerData.get(skillName);
		return null;
	}

	/**
	 * Sets when the skill will be usable again
	 *
	 * @param playerID  The uuid of the player
	 * @param skillName The name of the skill
	 * @param resetTime The reset time
	 */
	public static void setResetTime(UUID playerID, @NotNull String skillName, @NotNull Instant resetTime) {

		var data = cooldown.computeIfAbsent(playerID, k -> new HashMap<>());
		data.put(skillName, resetTime);
		cooldown.put(playerID, data);
	}

}
