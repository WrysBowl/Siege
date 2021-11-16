package net.siegerpg.siege.core.items.implemented.misc.cosmetics.uncommon

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StoneFace() : Cosmetic(
	name = "Stone Face",
	customModelData = 1,
	description = listOf(""),
	material = Material.OBSERVER,
) {

	constructor(quality: Int) : this() {
		this.quality = 50
		this.rarity = Rarity.UNCOMMON
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

}