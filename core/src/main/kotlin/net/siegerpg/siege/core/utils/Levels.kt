package net.siegerpg.siege.core.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.siegerpg.siege.core.cache.LevelEXPStorage
import net.siegerpg.siege.core.database.DatabaseManager
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import java.sql.ResultSet
import java.util.*
import kotlin.math.floor
import kotlin.math.pow

object Levels {
    fun calculateRequiredExperience(level: Short): Int {
        return (level + 3.0).pow(3).toInt()
    }

    fun getExpLevel(player: OfflinePlayer): Pair<Short, Int> {
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement(
                "SELECT level,experience FROM userData WHERE uuid=?",
                ResultSet.TYPE_SCROLL_SENSITIVE
            )
            stmt.setString(1, player.uniqueId.toString())
            val query = stmt.executeQuery();
            if (!query.isBeforeFirst) return Pair(0, 0)
            query.next()
            return Pair(query.getShort("level"), query.getInt("experience"))
        }
    }

    /**
     * Gets the exp and level of every player (sorted from highest level to lowest)
     * @param limit: Instead of getting exp&level of each single player you can choose how many players to get it from. Choose a number <= 0 to get everyone's level.
     */
    fun getAllExpLevel(limit: Int): ArrayList<Triple<UUID, Short, Int>> {
        val connection = DatabaseManager.getConnection()
        val arrayList = arrayListOf<Triple<UUID, Short, Int>>()
        val limitStr = if (limit <= 0) {
            ""
        } else {
            "LIMIT $limit"
        }
        connection!!.use {
            val stmt =
                connection.prepareStatement("SELECT level,experience,uuid FROM userData ORDER BY level DESC $limitStr")
            val query = stmt.executeQuery();
            if (!query.isBeforeFirst) return arrayList
            while (query.next()) {
                val triple = Triple(
                    UUID.fromString(query.getString("uuid")),
                    query.getShort("level"),
                    query.getInt("experience")
                )
                arrayList.add(triple)
            }
            return arrayList
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
                if (player.isOnline) {
                    (player as Player).level = level.toInt()
                }
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
    fun calculateExpLevel(level: Short, experience: Int, player: Player): Pair<Short, Int> {
        var exp = experience;
        var lvl = level;
        while (calculateRequiredExperience(lvl) <= exp) {
            exp -= calculateRequiredExperience(lvl)
            lvl = (lvl + 1).toShort()
            if (player.isOnline) {
                if (lvl % 10 == 0) {
                    Bukkit.getServer().broadcastMessage("")
                    Bukkit.getServer().broadcastMessage(Utils.tacc("&b&l" + player.name + "&r &7has reached level &d" + lvl + "!"))
                    Bukkit.getServer().broadcastMessage(Utils.tacc("&a/pv " + (lvl%10) + " &7is available"))
                    Bukkit.getServer().broadcastMessage("")
                    val multiplier = floor(lvl/10.0).toInt()
                    VaultHook.perms.playerAdd(player, "cosmicvaults.amount.${multiplier} true global")
                }
                player.sendTitle(
                    Utils.tacc("&5Level Up!"),
                    Utils.tacc("&c+2 HP"),
                    1, 80, 1
                )
            }
        }
        LevelEXPStorage.playerLevel[player] = lvl
        LevelEXPStorage.playerExperience[player] = exp
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
                    val p = (player as Player)
                    p.level = levelExp.first.toInt()
                    p.exp = levelExp.second / calculateRequiredExperience(levelExp.first).toFloat()
                }
            }
        }
    }

    fun setExp(player: OfflinePlayer, exp: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            val level = getExpLevel(player).first
            val new = calculateExpLevel(level, exp, player as Player)
            setExpLevel(player, new)
        }
    }

    fun addExp(player: OfflinePlayer, exp: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            val levelExp = getExpLevel(player)
            val new = calculateExpLevel(levelExp.first, levelExp.second + exp, player as Player)
            setExpLevel(player, new)
        }
    }
}