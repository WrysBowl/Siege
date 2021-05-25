package net.siegerpg.siege.dungeons

import io.lumine.xikage.mythicmobs.adapters.AbstractLocation
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitWorld
import net.siegerpg.siege.core.Core
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.OfflinePlayer
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.entity.Player
import java.util.*
import java.util.function.Consumer

/**
 * The Dungeon class.
 * It represents a single dungeon of a specific type, can be used to add players to it, remove players from, reset, etc.
 */
class Dungeon {
    var type: DungeonType
    var index: Int
    var currentPlayers = HashSet<OfflinePlayer>()

    /**
     * @return Returns the list of players in the dungeon
     */
    fun listPlayers(): HashSet<OfflinePlayer> {
        return currentPlayers
    }

    companion object {
        /**
         * Convert the selected configuration, index and type into a dungeon
         *
         * @param section
         * @param index
         */
        fun deserialize(
            section: ConfigurationSection,
            index: Int,
            type: DungeonType?,
            plugin: DungeonPlugin
        ): Dungeon {
            val dungeon = Dungeon(type!!, index, plugin)
            section.getStringList("players").forEach(Consumer { uuid: String? ->
                val player = Bukkit.getOfflinePlayer(UUID.fromString(uuid))
                dungeon.currentPlayers.add(player)
            })
            return dungeon
        }
    }

    var location: Location
    var dungeonPlugin: DungeonPlugin

    /**
     * Creates a dungeon instance with a specific type and index
     *
     * @param dungeonType
     * @param index
     */
    constructor(dungeonType: DungeonType, index: Int, plugin: DungeonPlugin) {
        this.index = index
        this.type = dungeonType
        location = Location(
            DungeonType.world, (type.dungeonDistance * index).toDouble(), 128.5,
            (750 * type.index).toDouble()
        )
        this.dungeonPlugin = plugin
        type.dungeons.add(this)
    }

    /**
     * Adds a player to the dungeon
     *
     * @param player
     */
    fun addPlayer(player: OfflinePlayer) {
        if (!currentPlayers.contains(player)) {
            currentPlayers.add(player)
            val dungeon = dungeonPlugin.dungeonConfig.getDungeon(type, index)
            if (dungeon.contains("players")) dungeon.getStringList("players").add(player.uniqueId.toString())
            else dungeon.set("players", listOf(player.uniqueId.toString()))
        }
        if (player.isOnline) (player as Player).teleport(location.clone().add(type.relSpawnLoc))
    }

    /**
     * Removes a player from the dungeon
     *
     * @param player The player to remove
     */
    fun removePlayer(player: OfflinePlayer) {
        if (currentPlayers.contains(player)) {
            currentPlayers.remove(player)
            var dungeon = dungeonPlugin.dungeonConfig.getDungeon(type, index)
            if (dungeon.contains("players"))
                dungeon.getStringList("players").remove(player.uniqueId.toString())
        }
        if (player.isOnline) (player as Player).teleport(Core.spawnLocation)
    }

    /**
     * Deletes the dungeon and its config
     */
    fun delete() {
        type.dungeons.remove(this)
        for (currentPlayer in currentPlayers) {
            removePlayer(currentPlayer)
        }
        dungeonPlugin.dungeonConfig.getDungeons(type).set(index.toString(), null)
    }

    /**
     * Reset the dungeon (remove all players and revert to the original schematic)
     */
    fun reset() {
        delete()
        SchematicPaster.pasteSchematic(type.schematic, location, false)
        type.dungeons.add(this)
        spawnBoss()
    }

    /**
     * Spawn the dungeon's boss
     */
    fun spawnBoss() {
        val bossLoc = location.clone().add(type.relBossLoc)
        type.boss.spawn(AbstractLocation(BukkitWorld(DungeonType.world), bossLoc.x, bossLoc.y, bossLoc.z), 1.0)
    }


}