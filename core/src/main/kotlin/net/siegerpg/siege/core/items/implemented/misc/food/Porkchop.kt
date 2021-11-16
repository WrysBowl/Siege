package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Porkchop() : CustomFood(
		name = "Porkchop",
		customModelData = 330006,
		description = listOf("Tastes better cooked..."),
		levelRequirement = 0,
		material = Material.PORKCHOP,
		health = 65.0,
                             ) {

	constructor(quality : Int) : this() {
		this.quality = 50
		this.rarity = Rarity.UNCOMMON
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		this.deserialize()
	}

}