package net.siegerpg.siege.dungeons

import net.siegerpg.siege.core.Core
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
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.event.player.PlayerTeleportEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import java.io.File

class DungeonRejoin(plugin: DungeonPlugin) : Listener, ConfigurationBase((File(plugin.dataFolder, "portal.yml"))) {

    var dungeonDeaths: HashMap<Player, Int> = hashMapOf()

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
    @EventHandler
    fun playerRespawn(e: PlayerRespawnEvent) {
        val player: Player = e.player
        for (dungeonType in DungeonType.dungeonTypes) {
            for (dungeon in dungeonType.dungeons) {
                if (dungeon.listPlayers().contains(player)) {
                    val count: Int = dungeonDeaths[player] ?: 0

                    dungeonDeaths[player] = count + 1
                    if (dungeonDeaths[player]!! < 3) {
                        player.sendMessage(Utils.lore("<yellow>You have ${3 - dungeonDeaths[player]!!} lives left!"))
                        player.sendTitle(Utils.tacc(""), Utils.tacc("<yellow>${3 - dungeonDeaths[player]!!} lives left"), 0, 100, 0)
                        e.respawnLocation = dungeon.getSpawn()
                    } else {
                        dungeon.delete()
                        e.respawnLocation = Core.plugin().server.getWorld("Hub")?.spawnLocation!!
                        dungeonDeaths[player] = 0
                    }
                    return
                }
            }
        }
    }

    @EventHandler
    fun playerTeleport(e: PlayerTeleportEvent) {
        val player: Player = e.player
        if (e.from.world.name != "Dungeons") return
        if (e.to.world.name != "Hub") return
        for (dungeonType in DungeonType.dungeonTypes) {
            for (dungeon in dungeonType.dungeons) {
                if (dungeon.listPlayers().contains(player)) {
                    dungeon.delete()
                    dungeonDeaths[player] = 0
                    return
                }
            }
        }
    }

    @EventHandler
    fun playerQuit(e: PlayerQuitEvent) {
        val player: Player = e.player
        if (player.world.name == "Dungeons")
        for (dungeonType in DungeonType.dungeonTypes) {
            for (dungeon in dungeonType.dungeons) {
                if (dungeon.listPlayers().contains(player)) { //This condition is not passing
                    dungeon.delete()
                    dungeonDeaths[player] = 0
                    return
                }
            }
        }
    }

}