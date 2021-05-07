package net.siegerpg.siege.core.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.siegerpg.siege.core.database.DatabaseManager
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import kotlin.math.pow

object Levels {
    fun calculateRequiredExperience(level: Short): Int {
        return (level + 3.0).pow(3).toInt()
    }

    fun getExpLevel(player: OfflinePlayer): Pair<Short, Int> {
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement("SELECT level,experience FROM userData WHERE uuid=?")
            stmt.setString(1, player.uniqueId.toString())
            val query = stmt.executeQuery();
            query.next()
            if (query.fetchSize < 1) return Pair(0, 0)
            return Pair(query.getShort("level"), query.getInt("experience"))
        }
    }

    fun setLevel(player: OfflinePlayer, level: Short) {
        GlobalScope.launch(Dispatchers.IO) {
            val connection = DatabaseManager.getConnection()
            connection!!.use {
                val stmt = connection.prepareStatement("UPDATE userData SET level=? WHERE uuid=?");
                stmt.setShort(1, level)
                stmt.setString(2, player.uniqueId.toString())
                stmt.executeUpdate()
                if (player.isOnline) (player as Player).level = level.toInt();
            }
        }
    }

    fun addLevel(player: OfflinePlayer, level: Short) {
        GlobalScope.launch(Dispatchers.IO) {
            val connection = DatabaseManager.getConnection()
            connection!!.use {
                val stmt = connection.prepareStatement("UPDATE userData SET level=level+? WHERE uuid=?");
                stmt.setShort(1, level)
                stmt.setString(2, player.uniqueId.toString())
                stmt.executeUpdate()
                if (player.isOnline) {
                    val p = player as Player
                    p.giveExpLevels(level.toInt())
                }
            }
        }
    }

    /**
     * Returns the new user level based on a level and exp
     */
    fun calculateExpLevel(level: Short, experience: Int): Pair<Short, Int> {
        var exp = experience;
        var lvl = level;
        while (calculateRequiredExperience(level) <= experience) {
            exp -= calculateRequiredExperience(level)
            lvl = (lvl + 1).toShort()
        }
        return Pair(lvl, exp)
    }

    fun setExpLevel(player: OfflinePlayer, levelExp: Pair<Short, Int>) {
        GlobalScope.launch(Dispatchers.IO) {
            val connection = DatabaseManager.getConnection()
            connection!!.use {
                val stmt = connection.prepareStatement("UPDATE userData SET level=?,experience=? WHERE uuid=?");
                stmt.setShort(1, levelExp.first)
                stmt.setInt(2, levelExp.second)
                stmt.setString(3, player.uniqueId.toString())
                stmt.executeUpdate()
                if (player.isOnline) {
                    val p = (player as Player);
                    p.level = levelExp.first.toInt();
                    p.exp = levelExp.second / calculateRequiredExperience(levelExp.first).toFloat()
                }
            }
        }
    }

    fun setExp(player: OfflinePlayer, exp: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            val level = getExpLevel(player).first
            val new = calculateExpLevel(level, exp)
            setExpLevel(player, new)
        }
    }

    fun addExp(player: OfflinePlayer, exp: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            val levelExp = getExpLevel(player)
            val new = calculateExpLevel(levelExp.first, levelExp.second + exp)
            setExpLevel(player, new)
        }
    }
}