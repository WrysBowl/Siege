package net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ShroomPowder() : CustomMaterial(
		name = "Shroom Powder",
		customModelData = 320012,
		description = listOf("Crushed shroomlights"),
		levelRequirement = 0,
		material = Material.FLINT,
		sellCost = 5
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

		fun tier(tier : Int) : ShroomPowder {
			val newItem = ShroomPowder(0)
			newItem.tier = tier
			return newItem
		}
	}

}