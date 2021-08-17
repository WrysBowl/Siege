package net.siegerpg.siege.dungeons

import io.lumine.xikage.mythicmobs.MythicMobs
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.OfflinePlayer
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.entity.Player
import org.bukkit.persistence.PersistentDataType
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
        ): Dungeon {
            val dungeon = Dungeon(type!!, index)
            section.getStringList("players").forEach(Consumer { uuid: String? ->
                val player = Bukkit.getOfflinePlayer(UUID.fromString(uuid))
                dungeon.currentPlayers.add(player)
            })
            return dungeon
        }
    }

    var location: Location

    /**
     * Creates a dungeon instance with a specific type and index
     *
     * @param dungeonType
     * @param index
     */
    constructor(dungeonType: DungeonType, index: Int) {
        this.index = index
        this.type = dungeonType
        location = Location(
            DungeonType.world, (type.dungeonDistance * index).toDouble(), 128.5,
            (750 * type.index).toDouble()
        )
        type.dungeons.add(this)
        DungeonPlugin.plugin().dungeonConfig.save()
    }

    /**
     * Adds a player to the dungeon
     *
     * @param player
     */
    fun addPlayer(player: OfflinePlayer) {
        if (!currentPlayers.contains(player)) {
            currentPlayers.add(player)
            val dungeon = DungeonPlugin.plugin().dungeonConfig.getDungeon(type, index)
            if (dungeon.contains("players")) dungeon.getStringList("players").add(player.uniqueId.toString())
            else dungeon.set("players", listOf(player.uniqueId.toString()))
        }
        if (player.isOnline) (player as Player).teleport(getSpawn())
        DungeonPlugin.plugin().dungeonConfig.save()
    }

    fun getSpawn() : Location{
        return location.clone().add(type.relSpawnLoc)
    }

    /**
     * Removes a player from the dungeon
     *
     * @param player The player to remove
     */
    fun removePlayer(player: OfflinePlayer) {
        if (currentPlayers.contains(player)) {
            currentPlayers.remove(player)
            val dungeon = DungeonPlugin.plugin().dungeonConfig.getDungeon(type, index)
            if (dungeon.contains("players"))
                dungeon.getStringList("players").remove(player.uniqueId.toString())
        }
        if (player.isOnline)
            Core.plugin().server.getWorld("Hub")?.let { (player as Player).teleport(it.spawnLocation) }
        DungeonPlugin.plugin().dungeonConfig.save()

    }

    /**
     * Deletes the dungeon and its config
     */
    fun delete() {
        for (currentPlayer in currentPlayers) {
            removePlayer(currentPlayer)
        }
        DungeonPlugin.plugin().dungeonConfig.getDungeons(type).set(index.toString(), null)
        type.dungeons.remove(this)
        DungeonPlugin.plugin().dungeonConfig.save()

    }

    /**
     * Reset the dungeon (remove all players and revert to the original schematic)
     */
    fun reset() {
        delete()
        SchematicPaster.pasteSchematic(type.schematic, location, false)
        type.dungeons.add(this)
        spawnBoss()
        DungeonPlugin.plugin().dungeonConfig.save()
    }

    /**
     * Spawn the dungeon's boss
     */
    fun spawnBoss() {
        val bossLoc = location.clone().add(type.relBossLoc)
        val boss = MythicMobs.inst().apiHelper.spawnMythicMob(type.boss, bossLoc, type.dungeonLevel)
        boss.persistentDataContainer.set(Utils.namespacedKey("dungeon"), PersistentDataType.INTEGER, index)
        boss.persistentDataContainer.set(Utils.namespacedKey("dungeon_type"), PersistentDataType.STRING, type.name)
    }


}