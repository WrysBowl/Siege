package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.items.CustomItemUtils.getCustomItem
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.types.misc.StatGemType
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment
import net.siegerpg.siege.core.utils.sendMiniMessage
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryAction
import org.bukkit.event.inventory.InventoryClickEvent

class StatGemListener : Listener {
    @EventHandler
    @Suppress("unused")
    fun onInventoryClick(e: InventoryClickEvent) {
        if (e.whoClicked !is Player) return
        if (e.action != InventoryAction.SWAP_WITH_CURSOR) return
        val player = e.whoClicked as Player
        val itemOnCursor = getCustomItem(e.cursor)
        val itemInteractedWith = getCustomItem(e.currentItem)
        if (itemOnCursor == null || itemInteractedWith == null) return
        if (itemOnCursor !is StatGemType) return
        if (itemInteractedWith !is CustomEquipment) return
        itemInteractedWith.statGem?.let {
            player.sendMiniMessage("<red>That item already has a stat gem!")
            return
        }

        if (itemOnCursor.levelRequirement!! > LevelEXPStorage.playerLevel[player.uniqueId]!!) {
            player.sendMiniMessage("<red>You are too low level to use this gem!")
            return
        }
        itemInteractedWith.addStatGem(StatGem(itemOnCursor.statType, itemOnCursor.statAmount))
        itemInteractedWith.updateMeta(false)
        e.currentItem = itemInteractedWith.item
        e.isCancelled = true
        val newItem = e.cursor
        if (newItem != null) {
            newItem.amount = newItem.amount-1
        }
        player.setItemOnCursor(newItem)
    }
}