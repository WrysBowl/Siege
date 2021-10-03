package net.siegerpg.siege.core.listeners

import io.papermc.paper.event.player.AsyncChatEvent
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils.getCustomItem
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorEquipEvent
import net.siegerpg.siege.core.utils.sendMiniMessage
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.InventoryAction
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent

class CosmeticsListener : Listener {

    @EventHandler
    fun onFuseAttempt(e: InventoryClickEvent) {
        if (e.whoClicked !is Player) return
        val player = e.whoClicked as Player
        val itemOnCursor = getCustomItem(e.cursor) //cosmetic helmet
        val itemInteractedWith = getCustomItem(e.currentItem) //helmet
        if (itemOnCursor == null && itemInteractedWith != null) { //remove cosmetic from helmet
            if (e.action != InventoryAction.PICKUP_HALF) return
            if (itemInteractedWith !is CustomHelmet) return //verify clicked item is a CustomHelmet
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
            if (itemInteractedWith !is CustomHelmet) return //verify both items are CustomHelmets
            if (itemOnCursor !is Cosmetic) return
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
            player.setItemOnCursor(
                itemOnCursor.item.asQuantity(itemOnCursor.item.amount-1)
            )
        }
    }

    @EventHandler
    fun onCosmeticHandEquipAttempt(e: PlayerInteractEvent) {
        val player = e.player
        val itemInteractedWith = getCustomItem(player.inventory.itemInMainHand) ?: return //helmet
        if (itemInteractedWith !is CustomHelmet) return //verify both items are CustomHelmets
        if (itemInteractedWith.storedItem == null ||
            itemInteractedWith.initMaterial == null ||
            itemInteractedWith.initCustomModelData == null) {
            return
        }
        if (player.inventory.helmet != null) return
        if (e.action == Action.RIGHT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_AIR) {
            player.inventory.helmet = itemInteractedWith.item //change clicked item to the new cosmetic item
            player.inventory.setItemInMainHand(
                player.inventory.itemInMainHand.asQuantity(player.inventory.itemInMainHand.amount-1)
            )
        }
    }

    @EventHandler
    fun onCosmeticInteract(e: PlayerInteractEvent) {
        val player = e.player
        val itemInteractedWith = getCustomItem(player.inventory.itemInMainHand) ?: return //helmet
        if (itemInteractedWith !is CustomHelmet) return //verify both items are CustomHelmets
        if (itemInteractedWith.storedItem == null ||
            itemInteractedWith.initMaterial == null ||
            itemInteractedWith.initCustomModelData == null) return
        val nbtItem: CustomItem = getCustomItem(itemInteractedWith.storedItem) ?: return
        if (nbtItem !is Cosmetic) return
        if (e.action == Action.LEFT_CLICK_AIR || e.action == Action.LEFT_CLICK_BLOCK) nbtItem.onCosmeticInteract(e)
    }

    @EventHandler
    fun onCosmeticEquip(e: ArmorEquipEvent) {
        val itemInteractedWith = getCustomItem(e.newArmorPiece) ?: return //helmet
        if (itemInteractedWith !is CustomHelmet) return //verify both items are CustomHelmets
        if (itemInteractedWith.storedItem == null ||
            itemInteractedWith.initMaterial == null ||
            itemInteractedWith.initCustomModelData == null) return
        val nbtItem: CustomItem = getCustomItem(itemInteractedWith.storedItem) ?: return
        if (nbtItem !is Cosmetic) return
        nbtItem.onCosmeticEquip(e)
    }

    @EventHandler
    fun onCosmeticSpeak(e: AsyncChatEvent) {
        val itemInteractedWith = getCustomItem(e.player.inventory.itemInMainHand) ?: return //helmet
        if (itemInteractedWith !is Cosmetic) return //verify both items are CustomHelmets
        itemInteractedWith.onCosmeticSpeak(e)
    }
}