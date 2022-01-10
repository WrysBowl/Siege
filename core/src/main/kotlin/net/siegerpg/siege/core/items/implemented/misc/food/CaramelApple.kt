package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CaramelApple() : CustomFood(
		name = "Caramel Aply",
		customModelData = 330013,
		description = listOf("A sweeter apple"),
		levelRequirement = 0,
		material = Material.APPLE,
		health = 60.0
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