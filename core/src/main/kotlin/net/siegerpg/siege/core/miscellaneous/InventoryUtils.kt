package net.siegerpg.siege.core.miscellaneous

import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent

val InventoryClickEvent.isMiddleClick : Boolean
	get() = this.click == ClickType.MIDDLE

val InventoryClickEvent.isDropClick : Boolean
	get() = this.click == ClickType.DROP

val InventoryClickEvent.isDropStackClick : Boolean
	get() = this.click == ClickType.CONTROL_DROP

val InventoryClickEvent.isOffhandKey : Boolean
	get() = this.click == ClickType.SWAP_OFFHAND