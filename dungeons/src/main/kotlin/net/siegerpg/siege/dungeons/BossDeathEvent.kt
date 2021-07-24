package net.siegerpg.siege.dungeons

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.utils.Utils
import net.siegerpg.siege.dungeons.portals.PortalConfig
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.persistence.PersistentDataType
import org.bukkit.scheduler.BukkitRunnable

class BossDeathEvent : Listener, Runnable {
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
                    Countdown().countdown(player, 15)
                }
            }
            Bukkit.getScheduler().runTaskLater(DungeonPlugin.plugin(), Runnable {
                dungeon?.delete()
            }, 300)
        }
        if (boss !is Player) return;
        val player: Player = e.entity as Player
        if (player.world == Core.plugin().server.getWorld("Dungeons")) { //Checks if player died in the dungeon world
            object : BukkitRunnable() {
                override fun run() {
                    Core.plugin().server.getWorld("Hub")?.let { player.teleport(it.spawnLocation) }
                }
            }.runTaskLater(Core.plugin(), 5)
        }
    }

    override fun run() {
    }
}