package net.siegerpg.siege.core.skills;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class SkillCooldown {

	public static HashMap< UUID, HashMap< String, Instant > > cooldown = new HashMap<>();

	/**
	 * Gets when the time will reset
	 *
	 * @param playerID The uuid of the player
	 * @param skill    The skill
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
	 * @param player  The player
	 * @param skill     The skill
	 * @param resetTime The reset time
	 */
	public static void setResetTime(Player player, @NotNull Skill skill, @NotNull Instant resetTime) {

		var data = cooldown.computeIfAbsent(player.getUniqueId(), k -> new HashMap<>());
		Listeners.CooldownTimeSetEvent evt = new Listeners.CooldownTimeSetEvent(
				player, skill, resetTime);
		Listeners.triggerCooldownTimeSetEvent(evt);
		data.put(evt.skill.getIdentifier(), evt.instant);
		cooldown.put(evt.player.getUniqueId(), data);
	}

	public static class Listeners {

		private static HashSet< CooldownListener > listeners = new HashSet<>();

		public static void register(CooldownListener listener) {

			listeners.add(listener);
		}

		private static void triggerCooldownTimeSetEvent(CooldownTimeSetEvent evt) {

			for (
					CooldownListener listener :
					listeners
			) {
				listener.onCooldownCreate(evt);
			}
		}

		/**
		 * The class of the event.
		 */
		public static class CooldownTimeSetEvent {

			private CooldownTimeSetEvent(Player player, Skill skill, Instant instant) {

				this.player = player;
				this.skill = skill;
				this.instant = instant;
			}

			private Player player;

			public Player getPlayer() {

				return player;
			}

			private Skill skill;

			public Skill getSkill() {

				return skill;
			}

			private Instant instant;

			public Instant getInstant() {

				return instant;
			}

			public void setInstant(Instant instant) {

				this.instant = instant;
			}

		}


	}

	public interface CooldownListener extends EventListener {

		void onCooldownCreate(Listeners.CooldownTimeSetEvent evt);

	}

}
