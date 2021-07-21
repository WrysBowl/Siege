package net.siegerpg.siege.core.skills

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.siegerpg.siege.core.database.DatabaseManager
import org.bukkit.OfflinePlayer
import java.sql.ResultSet

object Skills {
/*
    fun getSkills(player: OfflinePlayer): String {
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

    fun setSkills(player: OfflinePlayer, skills: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val connection = DatabaseManager.getConnection()
            connection!!.use {
                val stmt = connection.prepareStatement("UPDATE skillsData SET skills=? WHERE uuid=?");
                stmt.setString(1, skills)
                stmt.setString(2, player.uniqueId.toString())
                stmt.executeUpdate()
            }
        }
    }*/
}