package net.siegerpg.siege.core.utils

import io.github.retrooper.packetevents.event.PacketListenerAbstract
import io.github.retrooper.packetevents.event.impl.PacketPlaySendEvent
import io.github.retrooper.packetevents.packettype.PacketType
import io.github.retrooper.packetevents.packetwrappers.play.out.spawnentity.WrappedPacketOutSpawnEntity
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.setNbtTags
import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.bukkit.entity.Item
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.inventory.ItemStack
import java.util.*

class DropUtils : Listener, PacketListenerAbstract() {

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

    override fun onPacketPlaySend(evt: PacketPlaySendEvent) {
        if (evt.packetId == PacketType.Play.Server.SPAWN_ENTITY_SPAWN) {
            val wrappedPacket = WrappedPacketOutSpawnEntity(evt.nmsPacket)
            if (wrappedPacket.entity?.type != EntityType.DROPPED_ITEM)
                return
            val item = wrappedPacket.entity as Item
            val itemStack = item.itemStack
            val seepickableby = itemStack.getNbtTag<List<String>>("seepickableby")
                ?: return
            if (!seepickableby.contains(evt.player.uniqueId.toString()))
                evt.isCancelled = true
        }
    }


    companion object {
        fun dropItemForPlayers(loc: Location, item: ItemStack, players: List<UUID>): Item {
            return loc.world.dropItem(loc, item.setNbtTags(Pair("seepickableby", players.map { it::toString })))
        }
    }
}