package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HoneyOatBread() : CustomFood(
		name = "Honey-Oat Bread",
		customModelData = 330015,
		description = listOf("Delicious baked bread","fresh from the fires"),
		levelRequirement = 0,
		material = Material.BREAD,
		health = 100.0,
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