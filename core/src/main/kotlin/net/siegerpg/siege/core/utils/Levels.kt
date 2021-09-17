package net.siegerpg.siege.core.utils

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.database.DatabaseManager
import net.siegerpg.siege.core.levelReward.*
import net.siegerpg.siege.core.parties.Party
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask
import java.sql.ResultSet
import java.time.Instant
import java.util.*
import kotlin.math.pow

object Levels {
    // How long data is cached for
    private const val cacheDuration = 10 * 60;
    private val cachedLevelExp = HashMap<UUID, Triple<Short, Int, Instant>>()

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
        return (level + 3.0).pow(3).toInt()
    }

    /**
     * Gets the exp and level of a player.
     * @param runAfter A lambda/closure which does something with the exp/level data
     * @return The task that will fetch the data from the database
     */
    fun getExpLevel(player: OfflinePlayer, runAfter: (levelExp: Pair<Short, Int>?) -> Unit): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            // Checks the cache before everything else
            val cachedData = cachedLevelExp[player.uniqueId]
            val now = Instant.now();
            if (cachedData != null) {
                if (cachedData.third.plusSeconds(cacheDuration.toLong()).isAfter(now)) {
                    val pair = Pair(cachedData.first, cachedData.second)
                    runAfter(pair)
                    return@Runnable
                }
            }
            val connection = DatabaseManager.getConnection()
            connection!!.use {
                val stmt = connection.prepareStatement(
                    "SELECT level,experience FROM userData WHERE uuid=?",
                    ResultSet.TYPE_SCROLL_SENSITIVE
                )
                stmt.setString(1, player.uniqueId.toString())
                val query = stmt.executeQuery();
                if (!query.isBeforeFirst) {
                    runAfter(null)
                } else {
                    query.next()
                    val data = Pair(query.getShort("level"), query.getInt("experience"))
                    // Updates the cache, too
                    val dataToCache = Triple(data.first, data.second, now)
                    cachedLevelExp[player.uniqueId] = dataToCache

                    // Runs the passed function
                    runAfter(data)
                }
            }
        })
    }

    /**
     * Gets the exp and level of multiple players.
     * @param runAfter A lambda/closure which does something with the exp/level data
     * @return The task that will fetch the data from the database
     */
    fun getExpLevel(players: List<OfflinePlayer>, runAfter: (HashMap<UUID, Pair<Short, Int>>?) -> Unit): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            val connection = DatabaseManager.getConnection()
            // Gets the cache data for each cached player, and gets the data of the not-yet-cached players
            val playerIDs = players.map { p -> p.uniqueId }.toMutableSet()
            val map = HashMap<UUID, Pair<Short, Int>>()
            val now = Instant.now();
            playerIDs.forEach { id ->
                val cachedData = cachedLevelExp[id]
                if (cachedData != null && cachedData.third.plusSeconds(cacheDuration.toLong()).isAfter(now)) {
                    val pair = Pair(cachedData.first, cachedData.second)
                    map[id] = pair
                    playerIDs.remove(id)
                }
            }
            if (playerIDs.size == 0) {
                runAfter(if (map.size > 0) map else null)
                return@Runnable
            }
            connection!!.use {
                val stmt = connection.prepareStatement(
                    "SELECT level,experience FROM userData WHERE uuid IN ?",
                    ResultSet.TYPE_SCROLL_SENSITIVE
                )
                stmt.setArray(1, connection.createArrayOf("VARCHAR", playerIDs.toTypedArray()))
                val resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    val uuid = UUID.fromString(resultSet.getString("uuid"))
                    val result = Pair(resultSet.getShort("level"), resultSet.getInt("experience"))
                    map[uuid] = result
                    // Save user data to cache
                    cachedLevelExp[uuid] = Triple(result.first, result.second, Instant.now())
                }
            }
            runAfter(if (map.size > 0) map else null)
        })
    }

    /**
     * Gets the exp and level of every player (sorted from highest level to lowest)
     * This bypasses the cache so be careful not to overuse it.
     * @param limit: Instead of getting exp&level of each single player you can choose how many players to get it from. Choose a number <= 0 to get everyone's level.
     */
    fun getAllExpLevel(limit: Int, runAfter: (ArrayList<Triple<UUID, Short, Int>>?) -> Unit): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
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
                if (!query.isBeforeFirst) return@Runnable
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
            runAfter(if (arrayList.size > 0) arrayList else null)
        })
    }

    fun setLevel(player: OfflinePlayer, level: Short): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            val connection = DatabaseManager.getConnection()
            connection!!.use {
                val stmt = connection.prepareStatement("UPDATE userData SET level=? WHERE uuid=?");
                stmt.setShort(1, level)
                stmt.setString(2, player.uniqueId.toString())
                stmt.executeUpdate()
                if (player.isOnline) {
                    (player as Player).level = level.toInt()
                }
                // cache
                val levelExp = cachedLevelExp[player.uniqueId]
                cachedLevelExp[player.uniqueId] = Triple(level, levelExp?.second ?: 0, Instant.now())
            }
        })
    }

    fun addLevel(player: OfflinePlayer, level: Short): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
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
                // cache
                val levelExp = cachedLevelExp[player.uniqueId]
                cachedLevelExp[player.uniqueId] =
                    Triple(((levelExp?.first ?: 0) + level).toShort(), levelExp?.second ?: 0, Instant.now())
            }
        })
    }

    /**
     * Returns the new user level based on a level and exp
     */
    fun calculateExpLevel(level: Short, experience: Int, player: OfflinePlayer): Pair<Short, Int> {
        var exp = experience;
        var lvl = level;
        while (calculateRequiredExperience(lvl) <= exp) {
            exp -= calculateRequiredExperience(lvl)
            lvl = (lvl + 1).toShort()
            if (!player.isOnline) continue
            if (levelRewards.size < lvl + 2) continue //ensure that the level reward is set in the array list

            val reward: LevelReward = levelRewards[lvl.toInt() - 2]
            object : BukkitRunnable() {
                override fun run() {
                    reward.giveReward(player as Player, lvl)
                }
            }.runTask(Core.plugin())
        }
        return Pair(lvl, exp)
    }

    /**
     * Sets the exp and level of a player
     */
    fun setExpLevel(player: OfflinePlayer, levelExp: Pair<Short, Int>): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            val connection = DatabaseManager.getConnection()
            connection!!.use {
                val stmt = connection.prepareStatement("UPDATE userData SET level=?,experience=? WHERE uuid=?");
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
        })
    }

    /**
     * Sets the exp and level of multiple players
     */
    fun setExpLevel(data: HashMap<UUID, Pair<Short, Int>>): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
            val connection = DatabaseManager.getConnection()
            connection!!.use {
                val stm = connection.createStatement()
                // We batch the sql queries together for speed (it will only make one request instead of multiple)
                data.forEach { (uuid, data) ->
                    // We prepare the query
                    val stmt = connection.prepareStatement("UPDATE userData SET level=?,experience=? WHERE uuid=?");
                    stmt.setShort(1, data.first)
                    stmt.setInt(2, data.second)
                    stmt.setString(3, uuid.toString())
                    // We add it to the batch
                    stm.addBatch(stmt.toString())

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
                stm.executeBatch()
            }
        })
    }

    /**
     * Sets a player's exp
     */
    fun setExp(player: OfflinePlayer, exp: Int): BukkitTask {
        return getExpLevel(player) { pair ->
            val new = calculateExpLevel(pair?.first ?: 0, exp, player as Player)
            setExpLevel(player, new)
        }
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
    fun addExpShared(player: OfflinePlayer, exp: Int) {
        addExp(player, exp)
        val teamMembers = ArrayList<OfflinePlayer>()
        val party = Party.getPlayerParty(player)
            ?: return
        // Gets all members apart from the player
        party.getMembers().forEach { m ->
            if (m != player) {
                teamMembers.add(m)
            }
        }
        // Adds 1/10th of the exp to all the team members
        addExp(teamMembers, Math.floorDiv(exp, 10))
    }
}