package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CookedPork() : CustomFood(
		name = "Cooked Porkchop",
		customModelData = 1,
		description = listOf("Roasted pork is alright"),
		levelRequirement = 0,
		material = Material.COOKED_PORKCHOP,
		health = 150.0,
                               ) {

	constructor(quality : Int) : this() {
		this.quality = 70
		this.rarity = Rarity.RARE
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		this.deserialize()
	}

}