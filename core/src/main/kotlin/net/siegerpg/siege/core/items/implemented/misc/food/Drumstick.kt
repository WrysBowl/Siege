package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Drumstick() : CustomFood(
	name = "Drumstick",
	customModelData = 330001,
	description = listOf("Siege fried chicken"),
	levelRequirement = 0,
	material = Material.COOKED_CHICKEN,
	health = 20.0,
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