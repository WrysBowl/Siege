package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PumpkinPie() : CustomFood(
		name = "Pumpkin Pie",
		customModelData = 330011,
		description = listOf("The best pie"),
		levelRequirement = 0,
		material = Material.PUMPKIN_PIE,
		health = 20.0,
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