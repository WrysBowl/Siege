package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.recipes.CustomRecipe
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.PrepareItemCraftEvent

class VanillaCraftingEvents : Listener {
    @EventHandler
    @Suppress("unused")
    fun onPrepareCraft(e: PrepareItemCraftEvent) {
        if (e.isRepair) return
        val customMatrix: MutableList<CustomItem?> = mutableListOf()
        e.inventory.matrix.forEach {
            customMatrix.add(CustomItemUtils.getCustomItem(it))
        }
        val customRecipe = CustomRecipe.getRecipe(customMatrix)
        if (customRecipe == null) {
            e.inventory.result = null
            return
        }
        e.inventory.result = customRecipe.createItem(null, true).item
    }
}