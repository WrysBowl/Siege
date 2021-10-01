package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.CustomItemUtils.getCustomItem
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.sendMiniMessage
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryAction
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

class CosmeticsListener : Listener {

    @EventHandler
    fun onFuseAttempt(e: InventoryClickEvent) {
        if (e.whoClicked !is Player) return
        val player = e.whoClicked as Player
        val itemOnCursor = getCustomItem(e.cursor) //cosmetic helmet
        val itemInteractedWith = getCustomItem(e.currentItem) //helmet
        if (itemOnCursor == null && itemInteractedWith != null) { //remove cosmetic from helmet
            if (itemInteractedWith !is CustomHelmet) return //verify clicked item is a CustomHelmet

            if (itemInteractedWith.cosmetic) return //verify clicked item is not a cosmetic
            if (itemInteractedWith.storedItem == null ||
                itemInteractedWith.initMaterial == null ||
                itemInteractedWith.initCustomModelData == null) return

            //set clicked item's original values back
            player.setItemOnCursor(itemInteractedWith.unFuseCosmetic(false))
            itemInteractedWith.updateMeta(false)
            e.currentItem = itemInteractedWith.item //change clicked item to the new cosmetic item
            e.isCancelled = true
        } else if (itemOnCursor != null && itemInteractedWith != null) { //fusing held cosmetic to clicked item
            if (e.action != InventoryAction.SWAP_WITH_CURSOR) return
            if (itemInteractedWith !is CustomHelmet || itemOnCursor !is CustomHelmet) return //verify both items are CustomHelmets
            if (itemInteractedWith.cosmetic && !itemOnCursor.cosmetic) return //verify cursor is cosmetic, clicked item is not
            if (itemInteractedWith.storedItem != null ||
                itemInteractedWith.initMaterial != null ||
                itemInteractedWith.initCustomModelData != null) {
                player.sendMiniMessage("<red>That item is already attached to a cosmetic!")
                return
            }
            //Now we can begin fusing the sterile cosmetic and item

            //storing all changed variables to NBT
            itemInteractedWith.fuseCosmetic(itemOnCursor)
            itemInteractedWith.updateMeta(false)

            e.currentItem = itemInteractedWith.item //change clicked item to the new cosmetic item
            e.isCancelled = true
            player.setItemOnCursor(null)
        }
    }
}