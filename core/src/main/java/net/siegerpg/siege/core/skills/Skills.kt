package net.siegerpg.siege.core.skills

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.database.DatabaseManager
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import java.sql.ResultSet

object Skills {

	fun getSkills(player : OfflinePlayer) : String {
		val connection = DatabaseManager.getConnection()
		connection!!.use {
			val stmt = connection.prepareStatement(
					"SELECT skills FROM skillsData WHERE uuid=?",
					ResultSet.TYPE_SCROLL_SENSITIVE
			                                      )
			stmt.setString(1, player.uniqueId.toString())
			val query = stmt.executeQuery();
			if (!query.isBeforeFirst) return ""
			query.next()
			return query.getString("skills")
		}
	}

	fun setSkills(player : OfflinePlayer, skills : String) {
		Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
			val connection = DatabaseManager.getConnection()
			connection!!.use {
				val stmt =
						connection.prepareStatement("UPDATE skillsData SET skills=? WHERE uuid=?");
				stmt.setString(1, skills)
				stmt.setString(2, player.uniqueId.toString())
				stmt.executeUpdate()
			}
		})
	}
}