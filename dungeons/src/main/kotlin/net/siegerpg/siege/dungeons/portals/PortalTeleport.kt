package net.siegerpg.siege.dungeons.portals


import net.siegerpg.siege.dungeons.DungeonPlugin
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerPortalEvent

class PortalTeleport : Listener {
    @EventHandler
    fun portalEnter(e: PlayerPortalEvent) {
        val p = e.player
        if (DungeonPlugin.plugin().portalConfig.teleportToCorresponding(p))
            e.isCancelled = true
    }
}
