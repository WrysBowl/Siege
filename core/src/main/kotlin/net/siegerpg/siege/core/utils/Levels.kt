package net.siegerpg.siege.core.utils

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.database.DatabaseManager
import net.siegerpg.siege.core.levelReward.*
import net.siegerpg.siege.core.parties.Party
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask
import java.sql.ResultSet
import java.time.Instant
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.math.pow

object Levels {
    // How long data is cached for
    private const val cacheDuration = 10 * 60
    private val cachedLevelExp = ConcurrentHashMap<UUID, Triple<Short, Int, Instant>>()

    private val levelRewards: ArrayList<LevelReward> = arrayListOf(
        Reward1(), Reward2(), Reward3(), Reward4(), Reward5(),
        Reward6(), Reward7(), Reward8(), Reward9(), Reward10(),
        Reward11(), Reward12(), Reward13(), Reward14(), Reward15(),
        Reward16(), Reward17(), Reward18(), Reward19(), Reward20(),
        Reward21(), Reward22(), Reward23(), Reward24(), Reward25(),
        Reward26(), Reward27(), Reward28(), Reward29(), Reward30(),
        Reward31(), Reward32(), Reward33(), Reward34(), Reward35(),
        Reward36(), Reward37(), Reward38(), Reward39()
    )

    /**
     * Calculates the experience required to reach a level.
     */
    fun calculateRequiredExperience(level: Short): Int {
        return (level + 3.0).pow(2.7).toInt()
    }

    /**
     * Returns the new user level based on a level and exp
     */
    fun calculateExpLevel(level: Short, experience: Int, player: OfflinePlayer): Pair<Short, Int> {
        var exp = experience
        var lvl = level
        while (calculateRequiredExperience(lvl) <= exp) {
            exp -= calculateRequiredExperience(lvl)
            lvl++
            if (!player.isOnline) continue
            if (levelRewards.size < lvl + 2) continue //ensure that the level reward is set in the array list

            val reward: LevelReward = levelRewards[lvl.toInt() - 2]
            object : BukkitRunnable() {
                override fun run() {
                    reward.giveReward(player as Player)
                    player.playSound(player.location, Sound.BLOCK_BEACON_POWER_SELECT, 1.0f, 2.0f)
                    player.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 0.5f)
                }
            }.runTaskLater(Core.plugin(), 20)
        }
        return Pair(lvl, exp)
    }

    /**
     * Gets the exp and level of a player.
     * @param runAfter A lambda/closure which does something with the exp/level data
     * @return The task that will fetch the data from the database
     */
    fun getExpLevel(player: OfflinePlayer, runAfter: (levelExp: Pair<Short, Int>?) -> Unit): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            runAfter(blockingGetExpLevel(player))
        })
    }

    /**
     * Gets the exp and level of multiple players.
     * @param runAfter A lambda/closure which does something with the exp/level data
     * @return The task that will fetch the data from the database
     */
    fun getExpLevel(
        players: List<OfflinePlayer>,
        runAfter: (HashMap<UUID, Pair<Short, Int>>?) -> Unit
    ): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            runAfter(blockingGetExpLevel(players))
        })
    }

    /**
     * Gets the exp and level of every player (sorted from highest level to lowest)
     * This bypasses the cache so be careful not to overuse it.
     * @param limit: Instead of getting exp&level of each single player you can choose how many players to get it from. Choose a number <= 0 to get everyone's level.
     */
    fun getAllExpLevel(limit: Int, runAfter: (ArrayList<Triple<UUID, Short, Int>>?) -> Unit): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            runAfter(blockingGetAllExpLevel(limit))
        })
    }


    /**
     * Sets the exp and level of a player
     */
    fun setExpLevel(player: OfflinePlayer, levelExp: Pair<Short, Int>): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            blockingSetExpLevel(player, levelExp)
        })
    }

    /**
     * Sets the exp and level of multiple players
     */
    fun setExpLevel(data: HashMap<UUID, Pair<Short, Int>>): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            blockingSetExpLevel(data)
        })
    }

    /**
     * Adds experience (and levels up automatically) for one player
     */
    fun addExp(player: OfflinePlayer, expToAdd: Int): BukkitTask {
        return getExpLevel(player) { pair ->
            val new = calculateExpLevel(pair?.first ?: 0, (pair?.second ?: 0) + expToAdd, player as Player)
            setExpLevel(player, new)
        }
    }

    /**
     * Adds the same experience to multiple players
     */
    fun addExp(players: ArrayList<OfflinePlayer>, exp: Int): BukkitTask {
        return getExpLevel(players) { levelExp ->
            if (levelExp != null) {
                levelExp.forEach { (uuid, data) ->
                    // Updates the data in levelExp for each player to reflect the new exp and level
                    levelExp[uuid] = calculateExpLevel(data.first, data.second + exp, Bukkit.getOfflinePlayer(uuid))
                }
                // Finally sets the new exp and level for all the players in question
                setExpLevel(levelExp)
            } else {
                val startingLevelExp = HashMap<UUID, Pair<Short, Int>>()
                players.forEach { p ->
                    startingLevelExp[p.uniqueId] = calculateExpLevel(0, 0 + exp, p)
                }
                setExpLevel(startingLevelExp)
            }
        }
    }

    /**
     * Adds 100% of the experience to one player and 10% to all their party members
     */
    fun addExpShared(player: OfflinePlayer, exp: Int): List<BukkitTask> {
        val list = mutableListOf<BukkitTask>()
        list.add(addExp(player, exp))
        val teamMembers = ArrayList<OfflinePlayer>()
        val party = Party.getPlayerParty(player)
            ?: return list
        // Gets all members apart from the player
        party.getMembers().forEach { m ->
            if (m != player) {
                teamMembers.add(m)
            }
        }
        // Adds 1/10th of the exp to all the team members
        list.add(addExp(teamMembers, Math.floorDiv(exp, 10)))
        return list
    }

    // ---------------------------------------------------------
    // ------------------- BLOCKING METHODS --------------------
    // ---------------------------------------------------------

    /**
     * Gets the exp and level of a player, blocking the thread.
     * @return The level and exp
     */
    fun blockingGetExpLevel(player: OfflinePlayer): Pair<Short, Int>? {
        val cachedData = cachedLevelExp[player.uniqueId]
        val now = Instant.now()
        if (cachedData != null) {
            if (cachedData.third.plusSeconds(cacheDuration.toLong()).isAfter(now)) {
                return Pair(cachedData.first, cachedData.second)
            }
        }
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement(
                "SELECT level,experience FROM userData WHERE uuid=?",
                ResultSet.TYPE_SCROLL_SENSITIVE
            )
            stmt.setString(1, player.uniqueId.toString())
            val query = stmt.executeQuery()
            return if (!query.isBeforeFirst) {
                null
            } else {
                query.next()
                val data = Pair(query.getShort("level"), query.getInt("experience"))
                // Updates the cache, too
                val dataToCache = Triple(data.first, data.second, now)
                cachedLevelExp[player.uniqueId] = dataToCache

                // Returns null
                data
            }
        }
    }

    /**
     * Gets the exp and level of multiple players, blocking the thread.
     * @return The level and experience
     */
    fun blockingGetExpLevel(
        players: List<OfflinePlayer>
    ): HashMap<UUID, Pair<Short, Int>>? {
        // Gets the cache data for each cached player, and gets the data of the not-yet-cached players
        val playerIDs = players.map { p -> p.uniqueId }.toMutableSet()
        val map = HashMap<UUID, Pair<Short, Int>>()
        val now = Instant.now()
        playerIDs.forEach { id ->
            val cachedData = cachedLevelExp[id]
            if (cachedData != null && cachedData.third.plusSeconds(cacheDuration.toLong()).isAfter(now)) {
                val pair = Pair(cachedData.first, cachedData.second)
                map[id] = pair
                playerIDs.remove(id)
            }
        }
        if (playerIDs.size == 0) {
            return if (map.size > 0) map else null
        }
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement(
                String.format("SELECT level,experience,uuid FROM userData WHERE uuid IN (%s)",
                    playerIDs.joinToString(", ") { "?" }),
                ResultSet.TYPE_SCROLL_SENSITIVE
            )
            var currentIndex = 0
            playerIDs.forEach { id ->
                stmt.setString(++currentIndex, id.toString())
            }
            val resultSet = stmt.executeQuery()
            while (resultSet.next()) {
                val uuid = UUID.fromString(resultSet.getString("uuid"))
                val result = Pair(resultSet.getShort("level"), resultSet.getInt("experience"))
                map[uuid] = result
                // Save user data to cache
                cachedLevelExp[uuid] = Triple(result.first, result.second, Instant.now())
            }
        }
        return if (map.size > 0) map else null
    }

    /**
     * Gets the exp and level of every player (sorted from highest level to lowest), blocking the thread.
     * This bypasses the cache so be careful not to overuse it.
     * @param limit: Instead of getting exp&level of each single player you can choose how many players to get it from. Choose a number <= 0 to get everyone's level.
     */
    fun blockingGetAllExpLevel(limit: Int): ArrayList<Triple<UUID, Short, Int>>? {
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
            val query = stmt.executeQuery()
            if (!query.isBeforeFirst) return null
            while (query.next()) {
                val uuid = UUID.fromString(query.getString("uuid"))
                val data = Pair(query.getShort("level"), query.getInt("experience"))
                val triple = Triple(
                    uuid,
                    data.first,
                    data.second
                )
                arrayList.add(triple)
                // Updates the cache
                cachedLevelExp[uuid] = Triple(data.first, data.second, Instant.now())
            }
        }
        return if (arrayList.size > 0) arrayList else null
    }

    /**
     * Sets the exp and level of a player, blocking the thread
     */
    fun blockingSetExpLevel(player: OfflinePlayer, levelExp: Pair<Short, Int>) {
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement("UPDATE userData SET level=?,experience=? WHERE uuid=?")
            stmt.setShort(1, levelExp.first)
            stmt.setInt(2, levelExp.second)
            stmt.setString(3, player.uniqueId.toString())
            stmt.executeUpdate()
            if (player.isOnline) {
                val p = (player as Player)
                val lvl = levelExp.first.toInt()
                val exp = levelExp.second
                val expPercent = exp / calculateRequiredExperience(levelExp.first).toFloat()
                p.level = lvl
                p.exp = expPercent
                // Updates the cache
                cachedLevelExp[player.uniqueId] = Triple(levelExp.first, levelExp.second, Instant.now())
            }
        }
    }

    /**
     * Sets the exp and level of multiple players, blocking the thread
     */
    fun blockingSetExpLevel(data: HashMap<UUID, Pair<Short, Int>>) {
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement("UPDATE userData SET level=?,experience=? WHERE uuid=?")
            // We batch the sql queries together for speed (it will only make one request instead of multiple)
            data.forEach { (uuid, data) ->
                // We prepare the query
                stmt.setShort(1, data.first)
                stmt.setInt(2, data.second)
                stmt.setString(3, uuid.toString())
                // We add it to the batch
                stmt.addBatch()

                // Same process as in the setExpLevel method above
                val player = Bukkit.getOfflinePlayer(uuid)
                if (player.isOnline) {
                    val p = (player as Player)
                    val lvl = data.first.toInt()
                    val exp = data.second
                    val expPercent = exp / calculateRequiredExperience(data.first).toFloat()
                    p.level = lvl
                    p.exp = expPercent
                    // Updates the cache
                    cachedLevelExp[player.uniqueId] = Triple(data.first, data.second, Instant.now())
                }
            }
            // We execute the batch
            stmt.executeBatch()
        }
    }


}