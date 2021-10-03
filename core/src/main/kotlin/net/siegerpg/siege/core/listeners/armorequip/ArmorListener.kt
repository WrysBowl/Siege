package net.siegerpg.siege.core.listeners.armorequip

import net.siegerpg.siege.core.events.ArmorEquipEvent
import net.siegerpg.siege.core.events.ArmorEquipEvent.EquipMethod
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.inventory.*
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerItemBreakEvent
import org.bukkit.inventory.ItemStack


/**
 * @author Arnah
 * @since Jul 30, 2015
 */
class ArmorListener(private val blockedMaterials: List<String>) : Listener {
    //Event Priority is highest because other plugins might cancel the events before we check.
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun inventoryClick(e: InventoryClickEvent) {
        var shift = false
        var numberkey = false
        if (e.isCancelled) return
        if (e.action == InventoryAction.NOTHING) return  // Why does this get called if nothing happens??
        if (e.click == ClickType.SHIFT_LEFT || e.click == ClickType.SHIFT_RIGHT) {
            shift = true
        }
        if (e.click == ClickType.NUMBER_KEY) {
            numberkey = true
        }
        if (e.slotType != InventoryType.SlotType.ARMOR && e.slotType != InventoryType.SlotType.QUICKBAR && e.slotType != InventoryType.SlotType.CONTAINER) return
        if (e.clickedInventory != null && e.clickedInventory!!.type != InventoryType.PLAYER) return
        if (e.inventory.type != InventoryType.CRAFTING && e.inventory.type != InventoryType.PLAYER) return
        if (e.whoClicked !is Player) return
        var newArmorType = ArmorType.matchType(if (shift) e.currentItem else e.cursor)
        if (!shift && newArmorType != null && e.rawSlot != newArmorType.slot) {
            // Used for drag and drop checking to make sure you aren't trying to place a helmet in the boots slot.
            return
        }
        if (shift) {
            newArmorType = ArmorType.matchType(e.currentItem)
            if (newArmorType != null) {
                var equipping = true
                if (e.rawSlot == newArmorType.slot) {
                    equipping = false
                }
                if (newArmorType == ArmorType.HELMET && if (equipping) isAirOrNull(e.whoClicked.inventory.helmet) else !isAirOrNull(
                        e.whoClicked.inventory.helmet
                    ) || newArmorType == ArmorType.CHESTPLATE && if (equipping) isAirOrNull(e.whoClicked.inventory.chestplate) else !isAirOrNull(
                        e.whoClicked.inventory.chestplate
                    ) || newArmorType == ArmorType.LEGGINGS && if (equipping) isAirOrNull(e.whoClicked.inventory.leggings) else !isAirOrNull(
                        e.whoClicked.inventory.leggings
                    ) || newArmorType == ArmorType.BOOTS && if (equipping) isAirOrNull(e.whoClicked.inventory.boots) else !isAirOrNull(
                        e.whoClicked.inventory.boots
                    )
                ) {
                    val armorEquipEvent = ArmorEquipEvent(
                        e.whoClicked as Player,
                        EquipMethod.SHIFT_CLICK,
                        newArmorType,
                        if (equipping) null else e.currentItem,
                        if (equipping) e.currentItem else null
                    )
                    Bukkit.getServer().pluginManager.callEvent(armorEquipEvent)
                    if (armorEquipEvent.isCancelled()) {
                        e.isCancelled = true
                    }
                }
            }
        } else {
            var newArmorPiece = e.cursor
            var oldArmorPiece = e.currentItem
            if (numberkey) {
                if (e.clickedInventory!!.type == InventoryType.PLAYER) { // Prevents shit in the 2by2 crafting
                    // e.getClickedInventory() == The players inventory
                    // e.getHotBarButton() == key people are pressing to equip or unequip the item to or from.
                    // e.getRawSlot() == The slot the item is going to.
                    // e.getSlot() == Armor slot, can't use e.getRawSlot() as that gives a hotbar slot ;-;
                    val hotbarItem = e.clickedInventory!!.getItem(e.hotbarButton)
                    if (!isAirOrNull(hotbarItem)) { // Equipping
                        newArmorType = ArmorType.matchType(hotbarItem)
                        newArmorPiece = hotbarItem
                        oldArmorPiece = e.clickedInventory!!.getItem(e.slot)
                    } else { // Unequipping
                        newArmorType = ArmorType.matchType(if (!isAirOrNull(e.currentItem)) e.currentItem else e.cursor)
                    }
                }
            } else {
                if (isAirOrNull(e.cursor) && !isAirOrNull(e.currentItem)) { // unequip with no new item going into the slot.
                    newArmorType = ArmorType.matchType(e.currentItem)
                }
                // e.getCurrentItem() == Unequip
                // e.getCursor() == Equip
                // newArmorType = ArmorType.matchType(!isAirOrNull(e.getCurrentItem()) ? e.getCurrentItem() : e.getCursor());
            }
            if (newArmorType != null && e.rawSlot == newArmorType.slot) {
                var method: EquipMethod = EquipMethod.PICK_DROP
                if (e.action == InventoryAction.HOTBAR_SWAP || numberkey) method = EquipMethod.HOTBAR_SWAP
                val armorEquipEvent =
                    ArmorEquipEvent(e.whoClicked as Player, method, newArmorType, oldArmorPiece, newArmorPiece)
                Bukkit.getServer().pluginManager.callEvent(armorEquipEvent)
                if (armorEquipEvent.isCancelled()) {
                    e.isCancelled = true
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    fun playerInteractEvent(e: PlayerInteractEvent) {
        if (e.useItemInHand() == Event.Result.DENY) return
        //
        if (e.action == Action.PHYSICAL) return
        if (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK) {
            val player = e.player
            if (e.useInteractedBlock() != Event.Result.DENY) {
                if (e.clickedBlock != null && e.action == Action.RIGHT_CLICK_BLOCK && !player.isSneaking) { // Having both of these checks is useless, might as well do it though.
                    // Some blocks have actions when you right click them which stops the client from equipping the armor in hand.
                    val mat = e.clickedBlock!!.type
                    for (s in blockedMaterials) {
                        if (mat.name.equals(s, ignoreCase = true)) return
                    }
                }
            }
            val newArmorType = ArmorType.matchType(e.item)
            if (newArmorType != null) {
                if (newArmorType == ArmorType.HELMET && isAirOrNull(e.player.inventory.helmet) || newArmorType == ArmorType.CHESTPLATE && isAirOrNull(
                        e.player.inventory.chestplate
                    ) || newArmorType == ArmorType.LEGGINGS && isAirOrNull(e.player.inventory.leggings) || newArmorType == ArmorType.BOOTS && isAirOrNull(
                        e.player.inventory.boots
                    )
                ) {
                    val armorEquipEvent =
                        ArmorEquipEvent(e.player, EquipMethod.HOTBAR, ArmorType.matchType(e.item), null, e.item)
                    Bukkit.getServer().pluginManager.callEvent(armorEquipEvent)
                    if (armorEquipEvent.isCancelled()) {
                        e.isCancelled = true
                        player.updateInventory()
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun inventoryDrag(event: InventoryDragEvent) {
        // getType() seems to always be even.
        // Old Cursor gives the item you are equipping
        // Raw slot is the ArmorType slot
        // Can't replace armor using this method making getCursor() useless.
        val type = ArmorType.matchType(event.oldCursor)
        if (event.rawSlots.isEmpty()) return  // Idk if this will ever happen
        if (type != null && type.slot == event.rawSlots.stream().findFirst().orElse(0)) {
            val armorEquipEvent =
                ArmorEquipEvent(event.whoClicked as Player, EquipMethod.DRAG, type, null, event.oldCursor)
            Bukkit.getServer().pluginManager.callEvent(armorEquipEvent)
            if (armorEquipEvent.isCancelled()) {
                event.result = Event.Result.DENY
                event.isCancelled = true
            }
        }
        // Debug shit
        /*System.out.println("Slots: " + event.getInventorySlots().toString());
		System.out.println("Raw Slots: " + event.getRawSlots().toString());
		if(event.getCursor() != null){
			System.out.println("Cursor: " + event.getCursor().getType().name());
		}
		if(event.getOldCursor() != null){
			System.out.println("OldCursor: " + event.getOldCursor().getType().name());
		}
		System.out.println("Type: " + event.getType().name());*/
    }

    @EventHandler
    fun itemBreakEvent(e: PlayerItemBreakEvent) {
        val type = ArmorType.matchType(e.brokenItem)
        if (type != null) {
            val p = e.player
            val armorEquipEvent = ArmorEquipEvent(p, EquipMethod.BROKE, type, e.brokenItem, null)
            Bukkit.getServer().pluginManager.callEvent(armorEquipEvent)
            if (armorEquipEvent.isCancelled) {
                val i = e.brokenItem.clone()
                i.amount = 1
                i.durability = (i.durability - 1).toShort()
                if (type == ArmorType.HELMET) {
                    p.inventory.helmet = i
                } else if (type == ArmorType.CHESTPLATE) {
                    p.inventory.chestplate = i
                } else if (type == ArmorType.LEGGINGS) {
                    p.inventory.leggings = i
                } else if (type == ArmorType.BOOTS) {
                    p.inventory.boots = i
                }
            }
        }
    }

    @EventHandler
    fun playerDeathEvent(e: PlayerDeathEvent) {
        val p = e.entity
        if (e.keepInventory) return
        for (i in p.inventory.armorContents) {
            if (!isAirOrNull(i)) {
                Bukkit.getServer().pluginManager.callEvent(
                    ArmorEquipEvent(
                        p,
                        EquipMethod.DEATH,
                        ArmorType.matchType(i),
                        i,
                        null
                    )
                )
                // No way to cancel a death event.
            }
        }
    }

    companion object {
        /**
         * A utility method to support versions that use null or air ItemStacks.
         */
        fun isAirOrNull(item: ItemStack?): Boolean {
            return item == null || item.type == Material.AIR
        }
    }
}