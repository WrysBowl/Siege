package net.siegerpg.siege.core.listeners

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerItemHeldEvent
import org.bukkit.inventory.ItemStack


class NoBowMechanics : Listener {
    var storedItem = HashMap<Player?, ItemStack?>()

    @EventHandler
    fun playerItemHeldEvent(e: PlayerItemHeldEvent) {
        returnItem(e.player)
    }

    @EventHandler
    fun playerDropItemEvent(e: PlayerDropItemEvent) {
        returnItem(e.player)
    }

    @EventHandler
    fun entityShootBowEvent(e: EntityShootBowEvent) {
        if (e.entity is Player) {
            returnItem(e.entity as Player)
        }
    }

    private fun returnItem(player: Player) {
        if (storedItem.containsKey(player.player)) {
            val slot = player.inventory.size - 1
            player.inventory.setItem(slot, storedItem[player])
            player.updateInventory()
            storedItem.remove(player)
        }
    }

    @EventHandler
    fun playerInteractEvent(e: PlayerInteractEvent) {
        val p = e.player
        if (!(e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK)) return
        if (storedItem.containsKey(p)) return
        if (p.itemInHand.type != Material.BOW) return
        val slot = p.inventory.size - 1
        val item = p.inventory.getItem(slot)
        storedItem[p] = item
        p.inventory.setItem(slot, ItemStack(Material.ARROW, 1))
    }
}