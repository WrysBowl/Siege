package net.siegerpg.siege.core.utils

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.database.DatabaseManager
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.scheduler.BukkitTask
import java.sql.ResultSet
import java.time.Instant
import java.util.*

object Bank {

    // How long data is cached for
    private const val cacheDuration = 10 * 60;
    private val cachedBankData = HashMap<UUID, Triple<Short, Int, Instant>>()

    /**
     * Gets the bank level and amount of a player
     * @param runAfter A lambda/closure which does something with the bank data
     * @return The task that will fetch the data from the database
     */
    fun getBankLevelAmount(player: OfflinePlayer, runAfter: (Pair<Short, Int>?) -> Unit): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            runAfter(blockingGetBankLevelAmount(player))
        })
    }

    /**
     * Gets the bank level and amount of multiple players
     * @param runAfter A lambda/closure which does something with the bank data
     * @return The task that will fetch the data from the database
     */
    fun getBankLevelAmount(
        players: List<OfflinePlayer>,
        runAfter: (HashMap<UUID, Pair<Short, Int>>?) -> Unit
    ): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            runAfter(blockingGetBankLevelAmount(players))
        })
    }


    /**
     * Sets the bank level of a player
     */
    fun setBankLevel(player: OfflinePlayer, level: Short): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            blockingSetBankLevel(player, level)
        })
    }


    /**
     * Sets the bank amount of a player
     */
    fun setBankAmount(player: OfflinePlayer, amount: Int): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            blockingSetBankAmount(player, amount)
        })
    }

    // ---------------------------------------------------------
    // ------------------- BLOCKING METHODS --------------------
    // ---------------------------------------------------------

    /**
     * Gets the bank level and amount of a player, blocking the thread
     * @return The bank data
     */
    fun blockingGetBankLevelAmount(player: OfflinePlayer): Pair<Short, Int>? {
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement(
                "SELECT bankLvl FROM userData WHERE uuid=?",
                ResultSet.TYPE_SCROLL_SENSITIVE
            )
            stmt.setString(1, player.uniqueId.toString())
            val query = stmt.executeQuery();
            // If no rows were found don't runAfter
            if (!query.isBeforeFirst) {
                return null
            }
            query.next()
            val data = Pair(query.getShort("bankLvl"), query.getInt("bankAmt"))
            // Cache
            cachedBankData[player.uniqueId] = Triple(data.first, data.second, Instant.now())
            return data
        }
    }


    /**
     * Gets the bank level and amount of multiple players, blocking the thread
     * @return The bank data
     */
    fun blockingGetBankLevelAmount(
        players: List<OfflinePlayer>
    ): HashMap<UUID, Pair<Short, Int>>? {
        val connection = DatabaseManager.getConnection()
        val map = HashMap<UUID, Pair<Short, Int>>()
        val playerIDs = players.map { p -> p.uniqueId }.toMutableSet()
        val now = Instant.now();
        playerIDs.forEach { id ->
            val cachedData = cachedBankData[id]
            if (cachedData != null && cachedData.third.plusSeconds(cacheDuration.toLong()).isAfter(now)) {
                val pair = Pair(cachedData.first, cachedData.second)
                map[id] = pair
                playerIDs.remove(id)
            }
        }
        connection!!.use {
            // If all the data was already cached skip the db entirely
            if (playerIDs.size == 0) {
                return if (map.size > 0) map else null
            }

            val stmt = connection.prepareStatement(
                "SELECT bankLvl,bankAmt FROM userData WHERE uuid IN ?",
                ResultSet.TYPE_SCROLL_SENSITIVE
            )
            stmt.setArray(1, connection.createArrayOf("VARCHAR", playerIDs.toTypedArray()))
            val resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                val uuid = UUID.fromString(resultSet.getString("uuid"))
                val data = Pair(resultSet.getShort("bankLvl"), resultSet.getInt("bankAmt"))
                map[uuid] = data
                cachedBankData[uuid] = Triple(data.first, data.second, Instant.now())
            }
        }
        return if (map.size > 0) map else null
    }


    /**
     * Sets the bank level of a player, blocking the thread
     */
    fun blockingSetBankLevel(player: OfflinePlayer, level: Short) {
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement("UPDATE userData SET bankLvl=? WHERE uuid=?");
            stmt.setShort(1, level)
            stmt.setString(2, player.uniqueId.toString())
            stmt.executeUpdate()
            val cachedData = cachedBankData[player.uniqueId]
            cachedBankData[player.uniqueId] = Triple(level, cachedData?.second ?: 0, Instant.now())
        }
    }

    /**
     * Sets the bank amount of a player, blocking the thread
     */
    fun blockingSetBankAmount(player: OfflinePlayer, amount: Int) {
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement("UPDATE userData SET bankAmt=? WHERE uuid=?");
            stmt.setInt(1, amount)
            stmt.setString(2, player.uniqueId.toString())
            stmt.executeUpdate()
            val cachedData = cachedBankData[player.uniqueId]
            cachedBankData[player.uniqueId] = Triple(cachedData?.first ?: 0, amount, Instant.now())
        }
    }

}