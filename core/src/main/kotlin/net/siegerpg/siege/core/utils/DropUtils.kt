package net.siegerpg.siege.core.utils

import com.google.gson.Gson
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
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.inventory.ItemStack
import java.util.*

/**
 * Used to drop items only for certain players
 */
class DropUtils : Listener, PacketListenerAbstract() {

    /**
     * Disables item picking up for items you shouldn't be able to pick up.
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun onItemPickup(evt: EntityPickupItemEvent) {
        val item = evt.item.itemStack
        val seepickableby = item.getNbtTag<String>("seepickableby")
            ?: return
        if (evt.entityType != EntityType.PLAYER) return
        val player = evt.entity as Player
        val stringUUIDs = Gson().fromJson(seepickableby, Array<String>::class.java)
        // If seepickableby does not contain the player's uuid we cancel the evt
        println(stringUUIDs.joinToString(", "))
        println(player.uniqueId.toString())
        if (!stringUUIDs.contains(player.uniqueId.toString()))
            evt.isCancelled = true
    }

    /**
     * Doesn't send the entity spawn packet for those entities
     */
    override fun onPacketPlaySend(evt: PacketPlaySendEvent) {
        if (evt.packetId == PacketType.Play.Server.SPAWN_ENTITY_SPAWN) {
            println("Entity just spawned!")
            val wrappedPacket = WrappedPacketOutSpawnEntity(evt.nmsPacket)
            if (wrappedPacket.entity?.type != EntityType.DROPPED_ITEM)
                return
            val item = wrappedPacket.entity as Item
            println("Entity item")
            val itemStack = item.itemStack
            val seepickableby = itemStack.getNbtTag<String>("seepickableby")
                ?: return
            println("See pickable fetched: $seepickableby")
            val stringUUIDs = Gson().fromJson(seepickableby, Array<String>::class.java)

            println("IN PACKET: "+ stringUUIDs.joinToString(", "))
            println("IN PACKET: "+ evt.player.uniqueId.toString())
            if (!stringUUIDs.contains(evt.player.uniqueId.toString()))
                evt.isCancelled = true
        }
    }


    companion object {

        /**
         * Internal method used to set the nbt tags of an item
         */
        private fun itemWithSeepickableNbtTags(item: ItemStack, players: List<UUID>): ItemStack {
            val uuidArray = Gson().toJson(players.map { it::toString }.toTypedArray())
            return item.setNbtTags(Pair("seepickableby", uuidArray))
        }

        /**
         * Drops an item which will only be visible and pickable by specific players
         * @param loc The location to drop the item at
         * @param item The item to drop
         * @param players The list of player uuids that will be able to pick the item up
         */
        public fun dropItemForPlayers(loc: Location, item: ItemStack, players: List<UUID>): Item {
            return loc.world.dropItem(loc, itemWithSeepickableNbtTags(item, players))
        }

        /**
         * Drops an item naturally which will only be visible and pickable by specific players
         * @param loc The location to drop the item at
         * @param item The item to drop
         * @param players The list of player uuids that will be able to pick the item up
         */
        public fun dropItemNaturallyForPlayers(loc: Location, item: ItemStack, players: List<UUID>): Item {
            return loc.world.dropItemNaturally(
                loc,
                itemWithSeepickableNbtTags(item, players)
            )
        }
    }
}