package net.siegerpg.siege.core.skills;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.database.DatabaseManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class SkillData {

	static HashMap< UUID, JsonObject > skillCache = new HashMap<>();

	static JsonParser jsonParser = new JsonParser();

	/**
	 * Gets the skill level of a player
	 *
	 * @param player    The player to get the skill of
	 * @param skillName The name of the skill to get the level of
	 *
	 * @return The level
	 */
	public static int getSkillLevel(OfflinePlayer player, String skillName) {

		JsonElement data = getSkillData(player)
				.get(skillName);
		if (data == null) {
			return 0;
		} else {
			return data.getAsInt();
		}
	}

	/**
	 * Sets the skill level of a player to something
	 *
	 * @param player    The player
	 * @param skillName The skill name
	 * @param level     The skill level
	 */
	public static void setSkillLevel(OfflinePlayer player, String skillName, int level) {

		JsonObject data = getSkillData(player);
		data.addProperty(skillName, level);
		setSkillData(player, data);
	}

	@NotNull
	public static JsonObject getSkillData(OfflinePlayer player) {

		if (skillCache.containsKey(player.getUniqueId())) {
			return skillCache.get(player.getUniqueId());
		}

		try (var conn = DatabaseManager.INSTANCE.getConnection()) {
			assert conn != null;
			var stmt = conn.prepareStatement("SELECT skills FROM skillsData WHERE uuid=?");
			stmt.setString(1, player
					.getUniqueId()
					.toString());
			var result = stmt.executeQuery();
			if (result.isBeforeFirst()) {
				// There are no rows so we return an empty json object
				return jsonParser
						.parse("{}")
						.getAsJsonObject();
			}
			result.next();
			String rawSkills = result.getString("skills");
			result.close();
			JsonObject jsonObject = jsonParser
					.parse(rawSkills)
					.getAsJsonObject();
			skillCache.put(player.getUniqueId(), jsonObject);
			return jsonObject;
		} catch (SQLException e) {
			return jsonParser
					.parse("{}")
					.getAsJsonObject();
		}
	}

	/**
	 * Sets the skill data (asynchronously)
	 *
	 * @param player The player that owns the data
	 * @param data   The skill data
	 */
	public static void setSkillData(OfflinePlayer player, JsonObject data) {

		skillCache.put(player.getUniqueId(), data);
		if (skillCache.containsKey(player.getUniqueId()))
			Bukkit
					.getScheduler()
					.runTaskAsynchronously(Core.plugin(), () -> {
						try (var conn = DatabaseManager.INSTANCE.getConnection()) {
							assert conn != null;
							var stmt = conn.prepareStatement(
									"UPDATE skillsData SET skills=? WHERE uuid=?");
							stmt.setString(1, data.getAsString());
							stmt.setString(2, player
									.getUniqueId()
									.toString());
							stmt.executeUpdate();

						} catch (SQLException ignored) {
						}
					});
		else Bukkit
				.getScheduler()
				.runTaskAsynchronously(Core.plugin(), () -> {
					try (var conn = DatabaseManager.INSTANCE.getConnection()) {
						assert conn != null;
						var stmt = conn.prepareStatement(
								"INSERT INTO skillsData (uuid, skills) VALUES (?, ?)");
						stmt.setString(1, player
								.getUniqueId()
								.toString());
						stmt.setString(2, data.getAsString());
						stmt.executeUpdate();
					} catch (SQLException ignored) {
					}
				});
	}

}
