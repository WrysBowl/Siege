package net.siegerpg.siege.shops

import net.siegerpg.siege.core.items.CustomItem
import org.bukkit.inventory.ItemStack

data class ShopItem(
		val item : CustomItem,
		val buyPrice : Int,
		val recipe : Map<CustomItem, Int>,
		val craftable : Boolean,
		val generate : () -> ItemStack
                   )