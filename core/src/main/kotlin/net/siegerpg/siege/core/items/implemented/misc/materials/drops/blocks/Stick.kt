package net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Stick() : CustomMaterial(
		name = "Stick",
		customModelData = 320005,
		description = listOf("Foundational material to any structure"),
		levelRequirement = 0,
		material = Material.FLINT,

		) {

	constructor(quality : Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

	companion object {

		fun tier(tier : Int) : Stick {
			val newItem = Stick(0)
			newItem.tier = tier
			return newItem
		}
	}

}