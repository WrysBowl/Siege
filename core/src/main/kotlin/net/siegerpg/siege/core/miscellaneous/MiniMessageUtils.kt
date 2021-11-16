package net.siegerpg.siege.core.miscellaneous

import org.bukkit.entity.Player
import org.bukkit.inventory.meta.ItemMeta

fun ItemMeta.lore(line: String) {
	if (this.hasLore()) {
		val lore = this.lore()!!
		lore.add(Utils.lore(line))
		this.lore(lore)
	} else {
		this.lore(mutableListOf(Utils.lore(line)))
	}
}

fun ItemMeta.name(name: String) {
	this.displayName(Utils.lore(name))
}

fun Player.sendMiniMessage(input: String) {
	this.sendMessage(Utils.parse(input))
}