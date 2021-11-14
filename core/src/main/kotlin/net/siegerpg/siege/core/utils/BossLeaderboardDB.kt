package net.siegerpg.siege.core.utils

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.database.DatabaseManager
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitTask
import java.sql.ResultSet
import java.time.Instant
import java.util.*

object BossLeaderboardDB {

    // How long data is cached for
    private const val cacheDuration = 10 * 60;

    /**
     * A hashmap for caching the boss data
     * boss name:
     *      player id:
     *          percentage, seconds it took
     */
    private val cachedBossData = HashMap<String, HashMap<UUID, Triple<Byte, Int, Instant>>>()

    private fun setCacheData(bossName: String, player: UUID, data: Pair<Byte, Int>, timeSet: Instant) {
        if (cachedBossData[bossName] == null) cachedBossData[bossName] = HashMap()
        cachedBossData[bossName]!![player] = Triple(data.first, data.second, timeSet)
    }

    private fun getCacheData(bossName: String, player: UUID): Triple<Byte, Int, Instant>? {
        return cachedBossData[bossName]?.get(player)
    }

    /**
     * Returns boss leaderboard data
     * @param runAfter A lambda/closure which does something with the boss leaderboard data
     * @return The task that will fetch the data from the database
     */
    fun getBossLeaderboardData(player: UUID, bossName: String, runAfter: (Pair<Byte, Int>?) -> Unit): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            runAfter(blockingGetBossLeaderboardData(player, bossName))
        })

    }

    /**
     * Returns boss leaderboard data of multiple players
     * @param runAfter A lambda/closure which does something with the boss leaderboard data
     * @return The task that will fetch the data from the database
     */
    fun getBossLeaderboardData(
        players: List<UUID>,
        bossName: String,
        runAfter: (HashMap<UUID, Pair<Byte, Int>>?) -> Unit
    ): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            runAfter(blockingGetBossLeaderboardData(players, bossName))
        })

    }

    /**
     * Returns boss leaderboard data for the top 10 players of a boss
     * @param runAfter A lambda/closure which does something with the boss leaderboard data
     * @return The task that will fetch the data from the database
     */
    fun getBossLeaderboardTop10Data(
        bossName: String,
        runAfter: (HashMap<UUID, Pair<Byte, Int>>?) -> Unit
    ): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            runAfter(blockingGetBossLeaderboardTop10Data(bossName))
        })
    }

    /**
     * Sets the boss percentageDone and timeTaken for a player
     * @return The task that will fetch the data from the database
     */
    fun setBossData(bossName: String, playerID: UUID, data: Pair<Byte, Int>, then: () -> Unit = {}): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            blockingSetBossLeaderboardData(bossName, playerID, data)
            then()
        })
    }

    /**
     * Sets the boss percentageDone and timeTaken for multiple players
     * @return The task that will fetch the data from the database
     */
    fun setBossData(bossName: String, data: HashMap<UUID, Pair<Byte, Int>>, then: () -> Unit = {}): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            blockingSetBossLeaderboardData(bossName, data)
            then()
        })
    }
    // ---------------------------------------------------------
    // ------------------- BLOCKING METHODS --------------------
    // ---------------------------------------------------------

    /**
     * Returns boss leaderboard data, blocking the current thread
     * @return A Pair of the percentage and the seconds it took
     */
    fun blockingGetBossLeaderboardData(playerID: UUID, bossName: String): Pair<Byte, Int>? {
        val now = Instant.now()
        val cachedData = getCacheData(bossName, playerID)
        if (cachedData != null) {
            if (cachedData.third.plusSeconds(cacheDuration.toLong()).isAfter(Instant.now())) {
                return Pair(cachedData.first, cachedData.second)
            }
        }
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement(
                "SELECT percentageDone,timeTaken FROM bossData WHERE playerID=? AND bossName=?",
                ResultSet.TYPE_SCROLL_SENSITIVE
            )
            stmt.setString(1, playerID.toString())
            stmt.setString(2, bossName)
            val query = stmt.executeQuery();
            if (!query.isBeforeFirst) {
                return null
            }
            query.next()
            val data = Pair(query.getByte("percentageDone"), query.getInt("timeTaken"))
            // Cache
            setCacheData(bossName, playerID, data, now)
            return data
        }
    }

    /**
     * Returns boss leaderboard data for multiple players, blocking the current thread
     * @return A hashmap of uuid and Pair of the percentage and the seconds it took
     */
    fun blockingGetBossLeaderboardData(playerIDs: List<UUID>, bossName: String): HashMap<UUID, Pair<Byte, Int>>? {
        val now = Instant.now()
        val mutableIDs = playerIDs.toMutableSet()
        val map = HashMap<UUID, Pair<Byte, Int>>()
        mutableIDs.forEach { id ->
            val cachedData = getCacheData(bossName, id)
            if (cachedData != null && cachedData.third.plusSeconds(cacheDuration.toLong()).isAfter(now)) {
                val pair = Pair(cachedData.first, cachedData.second)
                map[id] = pair
                mutableIDs.remove(id)
            }
        }
        if (mutableIDs.size == 0) {
            return if (map.size > 0) map else null
        }

        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement(
                String.format("SELECT percentageDone,timeTaken,playerID FROM bossData WHERE bossName=? AND playerID IN (%s)",
                    mutableIDs.joinToString(", ") { "?" }),
                ResultSet.TYPE_SCROLL_SENSITIVE
            )
            var currentIndex = 0;
            stmt.setString(++currentIndex, bossName)
            mutableIDs.forEach { id ->
                stmt.setString(++currentIndex, id.toString())
            }
            val resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                val uuid = UUID.fromString(resultSet.getString("playerID"))
                val data = Pair(resultSet.getByte("percentageDone"), resultSet.getInt("timeTaken"))
                map[uuid] = data
                setCacheData(bossName, uuid, data, Instant.now())
            }
        }
        return if (map.size > 0) map else null
    }

    /**
     * Returns boss leaderboard data for the top 10 players of a boss, blocking the current thread
     * @return A hashmap of player uuid and Pair of the percentage and the seconds it took
     */
    fun blockingGetBossLeaderboardTop10Data(bossName: String): HashMap<UUID, Pair<Byte, Int>>? {
        val map = HashMap<UUID, Pair<Byte, Int>>()
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement(
                "SELECT percentageDone,timeTaken,playerID FROM bossData WHERE bossName=? ORDER BY percentageDone/timeTaken DESC LIMIT 10",
                ResultSet.TYPE_SCROLL_SENSITIVE
            )
            stmt.setString(1, bossName)
            val resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                val uuid = UUID.fromString(resultSet.getString("playerID"))
                val data = Pair(resultSet.getByte("percentageDone"), resultSet.getInt("timeTaken"))
                map[uuid] = data
                setCacheData(bossName, uuid, data, Instant.now())
            }
        }
        return if (map.size > 0) map else null
    }

    /**
     * Sets the boss percentageDone and timeTaken for a player, blocking the thread
     */
    fun blockingSetBossLeaderboardData(bossName: String, playerID: UUID, data: Pair<Byte, Int>) {
        val dbData = blockingGetBossLeaderboardData(playerID, bossName)
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            if (dbData != null) {
                // If the new db data would be worse than the current one then don't change anything
                if (dbData.first / dbData.second > data.first / data.second) return
                val stmt =
                    connection.prepareStatement("UPDATE bossData SET percentageDone=?,timeTaken=? WHERE playerID=? AND bossName=?");
                stmt.setByte(1, data.first)
                stmt.setInt(2, data.second)
                stmt.setString(3, playerID.toString())
                stmt.setString(4, bossName)
                stmt.executeUpdate()
            } else {
                val stmt =
                    connection.prepareStatement("INSERT INTO bossData (bossName, playerID, percentageDone, timeTaken) VALUES (?, ?, ?, ?)");
                stmt.setByte(3, data.first)
                stmt.setInt(4, data.second)
                stmt.setString(2, playerID.toString())
                stmt.setString(1, bossName)
                stmt.executeUpdate()
            }
            setCacheData(bossName, playerID, data, Instant.now())
        }
    }

    /**
     * Sets the boss percentageDone and timeTaken for a player, blocking the thread
     */
    fun blockingSetBossLeaderboardData(bossName: String, data: HashMap<UUID, Pair<Byte, Int>>) {
        val playerIDs = data.keys.toList()
        val dbData = blockingGetBossLeaderboardData(playerIDs, bossName)
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            var updateNumbers = 0
            var insertNumbers = 0

            val updateStmt =
                connection.prepareStatement("UPDATE bossData SET percentageDone=?, timeTaken=? WHERE playerID=? AND bossName=?")
            val insertStmt =
                connection.prepareStatement("INSERT INTO bossData (bossName, playerID, percentageDone, timeTaken) VALUES (?, ?, ?, ?)");
            data.forEach { (uuid, data) ->
                if (dbData?.get(uuid) != null) {
                    // If the new db data would be worse than the current one then don't change anything
                    if (dbData[uuid]!!.first / dbData[uuid]!!.second >= data.first / data.second) return
                    updateStmt.setByte(1, data.first)
                    updateStmt.setInt(2, data.second)
                    updateStmt.setString(3, uuid.toString())
                    updateStmt.setString(4, bossName)
                    updateStmt.addBatch()
                    updateNumbers++
                } else {
                    insertStmt.setByte(3, data.first)
                    insertStmt.setInt(4, data.second)
                    insertStmt.setString(2, uuid.toString())
                    insertStmt.setString(1, bossName)
                    insertStmt.addBatch()
                    insertNumbers++
                }
                setCacheData(bossName, uuid, data, Instant.now())
            }
            if (updateNumbers != 0)
                updateStmt.executeBatch()
            if (insertNumbers != 0)
                insertStmt.executeBatch()
        }
    }

}