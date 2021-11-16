package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Carrot() : CustomFood(
		name = "Carrot",
		customModelData = 330012,
		description = listOf("Baby carrots aren't", "a type of carrot"),
		levelRequirement = 0,
		material = Material.CARROT,
		health = 5.0,
                           ) {

	constructor(quality : Int) : this() {
		this.quality = 0
		this.rarity = Rarity.COMMON
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		this.deserialize()
	}

}