package net.siegerpg.siege.dungeons

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.persistence.PersistentDataType

class DeathEvent : Listener {
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
                    player.sendMessage("You successfully killed the boss! Teleporting you back to spawn in 10 seconds")
                    // Cool music/particles Wrys or someone else should add goes here
                }
            }
            GlobalScope.launch {
                delay(10000)
                dungeon?.reset()
            }
        }
    }
}