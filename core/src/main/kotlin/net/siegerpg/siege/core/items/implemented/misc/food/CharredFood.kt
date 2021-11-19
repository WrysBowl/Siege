package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CharredFood() : CustomFood(
		name = "Charred Food",
		customModelData = 1,
		description = listOf("The remains of something"),
		levelRequirement = 0,
		material = Material.DRIED_KELP,
		health = 10.0,
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