package net.siegerpg.siege.core.miscellaneous

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.database.DatabaseManager
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.scheduler.BukkitTask
import java.sql.ResultSet
import java.util.*

object WebstoreDB {

	/**
	 * Gets the store commands of a player.
	 * @param runAfter A lambda/closure which does something with the store commands data
	 * @return The task that will fetch the data from the database
	 */
	fun getStoreCommands(
		player: OfflinePlayer,
		runAfter: (commands: Array<String>?) -> Unit
	): BukkitTask {
		return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
			runAfter(blockingGetStoreCommands(player))
		})
	}

	/**
	 * Gets the store commands of multiple players.
	 * @param runAfter A lambda/closure which does something with the store commands data
	 * @return The task that will fetch the data from the database
	 */
	fun getStoreCommands(
		players: List<OfflinePlayer>,
		runAfter: (HashMap<UUID, ArrayList<String>>?) -> Unit
	): BukkitTask {
		return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
			runAfter(blockingGetStoreCommands(players))
		})
	}

	/**
	 * Gets the store commands of every player (sorted from highest level to lowest)
	 * This bypasses the cache so be careful not to overuse it.
	 * @param limit: Instead of getting store commands of each single player you can choose how many players to get it from. Choose a number <= 0 to get everyone's level.
	 */
	fun getAllStoreCommands(
		limit: Int,
		runAfter: (ArrayList<Pair<UUID, String>>?) -> Unit
	): BukkitTask {
		return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
			runAfter(blockingGetAllStoreCommands(limit))
		})
	}


	/**
	 * Sets the store commands of a player
	 */
	fun setStoreCommand(player: OfflinePlayer, cmdArgs: String): BukkitTask {
		return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
			blockingSetStoreCommands(player, cmdArgs)
		})
	}

	/**
	 * Sets the store commands of multiple players
	 */
	fun setStoreCommand(data: HashMap<UUID, String>): BukkitTask {
		return Bukkit.getScheduler().runTaskAsynchronously(Core.plugin(), Runnable {
			blockingSetStoreCommands(data)
		})
	}

	// ---------------------------------------------------------
	// ------------------- BLOCKING METHODS --------------------
	// ---------------------------------------------------------

	/**
	 * Gets the store commands of a player, blocking the thread.
	 * @return The store commands
	 */
	fun blockingGetStoreCommands(player: OfflinePlayer): Array<String>? {
		val connection = DatabaseManager.getConnection()
		connection!!.use {
			val stmt = connection.prepareStatement(
				"SELECT command FROM webstoreData WHERE uuid=?",
				ResultSet.TYPE_SCROLL_SENSITIVE
			)
			stmt.setString(1, player.uniqueId.toString())
			val query = stmt.executeQuery()
			return if (!query.isBeforeFirst) {
				null
			} else {
				val data: ArrayList<String> = arrayListOf()
				var i: Int = 0
				while (query.next()) {
					data.add(query.getString("command"))
					i++
				}
				data.toTypedArray()
			}
		}
	}

	/**
	 * Gets the store commands of multiple players, blocking the thread.
	 * @return The level and experience
	 */
	fun blockingGetStoreCommands(
		players: List<OfflinePlayer>
	): HashMap<UUID, ArrayList<String>>? {
		// Gets the cache data for each cached player, and gets the data of the not-yet-cached players
		val playerIDs = players.map { p -> p.uniqueId }.toMutableSet()
		val map = HashMap<UUID, ArrayList<String>>()
		if (playerIDs.size == 0) {
			return if (map.size > 0) map else null
		}
		val connection = DatabaseManager.getConnection()
		connection!!.use {
			val stmt = connection.prepareStatement(
				String.format("SELECT command,uuid FROM webstoreData WHERE uuid IN (%s)",
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
				val result = resultSet.getString("command")
				if (map[uuid] == null) {
					map[uuid] = arrayListOf(result)
				} else map[uuid]?.add(result)
			}
		}
		return if (map.size > 0) map else null
	}

	/**
	 * Gets the store commands of every player (sorted from highest level to lowest), blocking the thread.
	 * This bypasses the cache so be careful not to overuse it.
	 * @param limit: Instead of getting exp&level of each single player you can choose how many players to get it from. Choose a number <= 0 to get everyone's level.
	 */
	fun blockingGetAllStoreCommands(limit: Int): ArrayList<Pair<UUID, String>>? {
		val connection = DatabaseManager.getConnection()
		val arrayList = arrayListOf<Pair<UUID, String>>()
		val limitStr = if (limit <= 0) {
			""
		} else {
			"LIMIT $limit"
		}
		connection!!.use {
			val stmt =
				connection.prepareStatement("SELECT command,uuid FROM webstoreData DESC $limitStr")
			val query = stmt.executeQuery()
			if (!query.isBeforeFirst) return null
			while (query.next()) {
				val uuid = UUID.fromString(query.getString("uuid"))
				val data = query.getString("command")
				val double = Pair(
					uuid,
					data
				)
				arrayList.add(double)
			}
		}
		return if (arrayList.size > 0) arrayList else null
	}

	/**
	 * Sets the store commands of a player, blocking the thread
	 */
	fun blockingSetStoreCommands(player: OfflinePlayer, cmdArgs: String) {
		val connection = DatabaseManager.getConnection()
		connection!!.use {
			val stmt =
				connection.prepareStatement("INSERT INTO webstoreData (command,uuid) VALUES (?, ?)")
			stmt.setString(1, cmdArgs)
			stmt.setString(2, player.uniqueId.toString())
			stmt.executeUpdate()
		}
	}

	/**
	 * Sets the store commands of multiple players, blocking the thread
	 */
	fun blockingSetStoreCommands(data: HashMap<UUID, String>) {
		val connection = DatabaseManager.getConnection()
		connection!!.use {
			val stmt =
				connection.prepareStatement("INSERT INTO webstoreData (command,uuid) VALUES (?, ?)")
			// We batch the sql queries together for speed (it will only make one request instead of multiple)
			data.forEach { (uuid, data) ->
				// We prepare the query
				stmt.setString(1, data)
				stmt.setString(2, uuid.toString())
				// We add it to the batch
				stmt.addBatch()
			}
			// We execute the batch
			stmt.executeBatch()
		}
	}

	/**
	 * Removes the store commands of a player, blocking the thread.
	 * @return The store commands
	 */
	fun blockingRemoveStoreCommands(player: OfflinePlayer) {
		val connection = DatabaseManager.getConnection()
		connection!!.use {
			val stmt = connection.prepareStatement(
				"DELETE FROM webstoreData WHERE uuid=?",
				ResultSet.TYPE_SCROLL_SENSITIVE
			)
			stmt.setString(1, player.uniqueId.toString())
			stmt.executeUpdate()
		}
	}

}