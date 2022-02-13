package net.siegerpg.siege.core.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerPortalEvent

class CustomPortalTeleportListener : Listener{
        @EventHandler
        fun portalEnter(e: PlayerPortalEvent) {
            val p = e.player
          /*  if (Core.plugin().portalConfig.teleportToCorresponding(p))
                e.isCancelled = true*/
        }

}