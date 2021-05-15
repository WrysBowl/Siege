package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.items.CustomItemUtils.getCustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.types.misc.StatGemType
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment
import net.siegerpg.siege.core.utils.VaultHook
import net.siegerpg.siege.core.utils.sendMiniMessage
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryAction
import org.bukkit.event.inventory.InventoryClickEvent
import kotlin.math.pow

class StatGemListener : Listener {
    @EventHandler
    @Suppress("unused")
    fun onInventoryClick(e: InventoryClickEvent) {
        if (e.whoClicked !is Player) return
        if (e.action != InventoryAction.SWAP_WITH_CURSOR) return
        //Bukkit.getLogger().info("Inventory Action: ${e.action}")
        val player = e.whoClicked as Player
        val inventory = e.view.bottomInventory
        val itemOnCursor = getCustomItem(e.cursor)
        val itemInteractedWith = getCustomItem(e.currentItem)
        if (itemOnCursor == null || itemInteractedWith == null) return
        //Bukkit.getLogger().info("Both are not null")
        if (itemOnCursor !is StatGemType) return
        //Bukkit.getLogger().info("Both are not null")
        if (itemInteractedWith !is CustomEquipment) return
        itemInteractedWith.statGem?.let {
            player.sendMiniMessage("<red>That item already has a stat gem!")
            return
        }
        if (!VaultHook.econ.has(player, itemOnCursor.statAmount.pow(3)))
            return player.sendMiniMessage("<red>You don't have enough money! (\$${itemOnCursor.statAmount.pow(3)}")
        VaultHook.econ.withdrawPlayer(player, itemOnCursor.statAmount.pow(3))
        itemInteractedWith.addStatGem(StatGem(itemOnCursor.statType, itemOnCursor.statAmount))
        itemInteractedWith.updateMeta(false)
        e.currentItem = itemInteractedWith.item
        e.isCancelled = true
        player.setItemOnCursor(null)
    }
}