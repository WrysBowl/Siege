package net.siegerpg.siege.core.utils

import io.github.retrooper.packetevents.PacketEvents
import io.github.retrooper.packetevents.packetwrappers.play.out.entitydestroy.WrappedPacketOutEntityDestroy
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.setNbtTags
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.bukkit.entity.Item
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.inventory.ItemStack
import java.util.*

class DropUtils : Listener {

    @EventHandler
    fun onItemPickup(evt: EntityPickupItemEvent) {
        val item = evt.item.itemStack
        val seepickableby = item.getNbtTag<List<String>>("seepickableby")
            ?: return
        if (evt.entityType != EntityType.PLAYER) return
        val player = evt.entity as Player
        // If seepickableby does not contain the player's uuid we cancel the evt
        if (!seepickableby.contains(player.uniqueId.toString()))
            evt.isCancelled = true
    }


    companion object {
        fun dropItemForPlayers(loc: Location, item: ItemStack, players: List<UUID>): Item {
            val droppedItem =
                loc.world.dropItem(loc, item.setNbtTags(Pair("seepickableby", players.map { it::toString })))
            val playersToHideThisFrom = Bukkit.getOnlinePlayers().filter { p -> !players.contains(p.uniqueId) }
            val wrappedPacket = WrappedPacketOutEntityDestroy(droppedItem.entityId)
            playersToHideThisFrom.forEach { p ->
                PacketEvents.get().playerUtils.sendPacket(p, wrappedPacket)
            }
            return droppedItem
        }
    }
}