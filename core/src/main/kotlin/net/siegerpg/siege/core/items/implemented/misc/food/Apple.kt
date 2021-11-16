package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Apple() : CustomFood(
	name = "Apple",
	customModelData = 330003,
	description = listOf("Food to tame teachers"),
	levelRequirement = 0,
	material = Material.APPLE,
	health = 20.0
) {

	constructor(quality: Int) : this() {
		this.quality = 0
		this.rarity = Rarity.COMMON
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		this.deserialize()
	}

}