package net.siegerpg.siege.dungeons

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.utils.ConfigurationBase
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.World
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.event.player.PlayerTeleportEvent
import org.bukkit.persistence.PersistentDataType
import org.bukkit.scheduler.BukkitRunnable
import org.jetbrains.annotations.Nullable
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
                    Countdown().countdown(player, dungeon, 30)
                }
            }
        }
    }
    //Player join event (if player quits the server check if their name is in the dungeon configs and teleport them to their dungeon)
    //Player teleport event (if player teleports outside the dungeon then delete it)
    //
    @EventHandler
    fun playerRespawn(e: PlayerRespawnEvent) {
        val player: Player = e.player
        if (player.world.name != "dungeons") return
        val coordinateSection = configuration.getConfigurationSection("coords") ?: configuration.createSection("coords")
        val linkingSection =
            configuration.getConfigurationSection("relations") ?: configuration.createSection("relations")
        val corresponding = coordinateSection.getLong(
            serializeLocation(player.location.block.location), -1
        )
        if (corresponding == -1L) {
            return
        }
        val location = linkingSection.getConfigurationSection(
            corresponding.toString()
        ) ?: return
        if (location.isSet("dungeon")) {
            val dungeonTypeName = location.getString("dungeon")
            val dungeonType = DungeonType.dungeonTypes.find { d -> dungeonTypeName == d.name } ?: return
            for (dungeon in dungeonType.dungeons) {
                if (dungeon.listPlayers().contains(player)) {
                    e.respawnLocation = dungeon.getDungeonLocation()
                    return
                }
            }
        }
    }

    @EventHandler
    fun playerTeleport(e: PlayerTeleportEvent) {
        val player: Player = e.player
        if (player.world.name != "dungeons") return
        val coordinateSection = configuration.getConfigurationSection("coords") ?: configuration.createSection("coords")
        val linkingSection =
            configuration.getConfigurationSection("relations") ?: configuration.createSection("relations")
        val corresponding = coordinateSection.getLong(
            serializeLocation(player.location.block.location), -1
        )
        if (corresponding == -1L) {
            return
        }
        val location = linkingSection.getConfigurationSection(
            corresponding.toString()
        ) ?: return
        if (location.isSet("dungeon")) {
            val dungeonTypeName = location.getString("dungeon")
            val dungeonType = DungeonType.dungeonTypes.find { d -> dungeonTypeName == d.name } ?: return
            for (dungeon in dungeonType.dungeons) {
                if (dungeon.listPlayers().contains(player)) {
                    dungeon.delete()
                    return
                }
            }
        }
    }

    @EventHandler
    fun playerJoin(e: PlayerJoinEvent) {
        val player: Player = e.player
        val coordinateSection = configuration.getConfigurationSection("coords") ?: configuration.createSection("coords")
        val linkingSection =
            configuration.getConfigurationSection("relations") ?: configuration.createSection("relations")
        val corresponding = coordinateSection.getLong(
            serializeLocation(player.location.block.location), -1
        )
        if (corresponding == -1L) {
            return
        }
        val location = linkingSection.getConfigurationSection(
            corresponding.toString()
        ) ?: return
        if (location.isSet("dungeon")) {
            val dungeonTypeName = location.getString("dungeon")
            val dungeonType = DungeonType.dungeonTypes.find { d -> dungeonTypeName == d.name } ?: return
            for (dungeon in dungeonType.dungeons) {
                if (dungeon.listPlayers().contains(player)) {

                    object : BukkitRunnable() {
                        //BukkitRunnable, not Runnable
                        var countdown = 5 //Instance variable in our anonymous class to easily hold the countdown value
                        override fun run() {
                            if (countdown <= 0 || !player.isOnline) { //countdown is over or player left the server, just two example reasons to exit
                                player.teleport(dungeon.getDungeonLocation())
                                this.cancel() //cancel the repeating task
                                return  //exit the method
                            }
                            player.sendTitle(Utils.tacc("&6Teleporting to Dungeon..."), Utils.tacc("&e$countdown seconds"), 0, 30, 0)
                            countdown-- //decrement
                        }
                    }.runTaskTimer(
                        Core.plugin(),
                        0,
                        20
                    )
                    return

                }
            }
        }
    }

    private fun serializeLocation(loc: Location): String {
        return "${loc.x};${loc.y};${loc.z};${loc.world.name}"
    }
}