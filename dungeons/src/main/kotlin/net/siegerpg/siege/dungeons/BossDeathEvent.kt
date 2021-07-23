package net.siegerpg.siege.dungeons

import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.persistence.PersistentDataType

class BossDeathEvent : Listener {
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
                    var i = 1
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(DungeonPlugin.plugin(), Runnable {
                        player.sendTitle(Utils.tacc("&6Teleporting to Hub..."), Utils.tacc("&e$i seconds"), 0, 20, 0)
                        i++
                    }, 20, 15)
                }
            }
            Bukkit.getScheduler().runTaskLater(DungeonPlugin.plugin(), Runnable {
                dungeon?.reset()
            }, 300)
        }
    }
}