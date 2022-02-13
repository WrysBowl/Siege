package net.siegerpg.siege.dungeons

import io.lumine.xikage.mythicmobs.MythicMobs
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent

class DeathEvent : Listener {
    @EventHandler
    fun mobDeath(e: EntityDeathEvent) {
        val mm = MythicMobs.inst().apiHelper.getMythicMobInstance(e.entity)
        val dungeonType = DungeonType.dungeonTypes.find { dungeonType ->
            //TODO: Find if the mob is the one that was spawned in the dungeon, get dungeon type and dungeon from x and z coordinates then find exact match, then wait 15 seconds and do the dungeon closing thing
            true
        }
    }
}