package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class GoldenCarrot() : CustomFood(
	name = "Golden Carrot",
	customModelData = 330005,
	description = listOf("Mercy on your soul"),
	levelRequirement = 0,
	material = Material.GOLDEN_CARROT, //change this to cooked chicken later
	health = 200.0
) {

	constructor(quality: Int) : this() {
		this.quality = 100
		this.rarity = Rarity.LEGENDARY
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		this.deserialize()
	}

}