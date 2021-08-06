package net.siegerpg.siege.dungeons

import net.siegerpg.siege.core.utils.ConfigurationBase
import net.siegerpg.siege.core.utils.Utils
import net.siegerpg.siege.dungeons.timers.Countdown
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.persistence.PersistentDataType
import java.io.File

class DungeonRejoin(plugin: DungeonPlugin) : Listener, ConfigurationBase((File(plugin.dataFolder, "portal.yml"))) {
    @EventHandler
    fun mobDeath(e: EntityDeathEvent) {
        val boss = e.entity
        val dungeonIndex = boss.persistentDataContainer.get(Utils.namespacedKey("dungeon"), PersistentDataType.INTEGER)
        val dungeonTypeName =
            boss.persistentDataContainer.get(Utils.namespacedKey("dungeon_type"), PersistentDataType.STRING)
        val dungeonType = DungeonType.dungeonTypes.find { d -> d.name == dungeonTypeName }
        if (dungeonType != null) {
            val dungeon = dungeonType.dungeons.find { d -> d.index == dungeonIndex }
            dungeon?.currentPlayers?.forEach { p ->
                if (p.isOnline) {
                    val player = (p as Player)
                    player.playSound(player.location, Sound.ENTITY_WITHER_DEATH,10.0f, 10.0f)
                    Countdown().dungeonLeave(player, dungeon, 30)
                }
            }
        }
    }
    //Player join event (if player quits the server check if their name is in the dungeon configs and teleport them to their dungeon)
    //Player teleport event (if player teleports outside the dungeon then delete it)
    //**TO DO**
    //(For Wrys)
    //> 1. Upgrade server to 1.17 with all it's plugins
    //> 2. Implement fishing baits into the fishing shop
    //> 3. Work on checking if the player has disconnected while inside the dungeon, they get respawned at the dungeon spawn point when they rejoin (UNTESTED)
    //> 4. Work on spreadsheet items
    //> 5. Allow players to respawn in their dungeon (UNTESTED)
    @EventHandler
    fun playerRespawn(e: PlayerRespawnEvent) {
        val player: Player = e.player
        for (dungeonType in DungeonType.dungeonTypes) {
            for (dungeon in dungeonType.dungeons) {
                if (dungeon.listPlayers().contains(player)) {
                    e.respawnLocation = dungeon.getSpawn()
                    Bukkit.getLogger().info("Respawn location: ${e.respawnLocation}")
                    return
                }
            }
        }
    }

    @EventHandler
    fun playerJoin(e: PlayerJoinEvent) {
        val player: Player = e.player
        for (dungeonType in DungeonType.dungeonTypes) {
            for (dungeon in dungeonType.dungeons) {
                if (dungeon.listPlayers().contains(player)) { //This condition is not passing
                    Countdown().dungeonJoin(player, dungeon, 5)
                    return
                }
            }
        }
    }

}