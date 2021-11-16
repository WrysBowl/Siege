package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Watermelon() : CustomFood(
	name = "Watermelon",
	customModelData = 330010,
	description = listOf(
		"A large oblong fruit with",
		"a hard green or white rind",
		"often striped or variegated"
	                    ),
	levelRequirement = 0,
	material = Material.MELON_SLICE,
	health = 10.0,
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