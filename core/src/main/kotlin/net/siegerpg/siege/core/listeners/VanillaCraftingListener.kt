package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.CustomRecipe
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryType
import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.bukkit.inventory.CraftingInventory

class VanillaCraftingListener : Listener {
    @EventHandler
    @Suppress("unused")
    fun onPrepareCraft(e: PrepareItemCraftEvent) {
        if (e.isRepair) return
        val customMatrix: MutableList<CustomItem?> = mutableListOf()
        e.inventory.matrix.forEach {
            customMatrix.add(CustomItemUtils.getCustomItem(it))
        }
        val customRecipe = CustomRecipe.getRecipe(customMatrix)
        customRecipe?.let {
            e.inventory.result = it.createItem(e.inventory.viewers.get(0) as Player, true).item
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    @Suppress("unused")
    fun onCraft(e: CraftItemEvent) {
        println("craft event")
        //e.isCancelled = true
    }

//    @EventHandler
//    @Suppress("unused")
//    fun onResultClick(e: InventoryClickEvent) {
//        if (e.clickedInventory == null || e.clickedInventory !is CraftingInventory || e.slotType != InventoryType.SlotType.RESULT) return
//        return
//        val customItem = CustomItemUtils.getCustomItem(e.currentItem)
//        customItem?.let {
//            it.quality = Utils.randRarity()
//            it.rarity = Rarity.getFromInt(it.quality)
//            e.currentItem = it.getUpdatedItem(false)
//        }
//    }
}