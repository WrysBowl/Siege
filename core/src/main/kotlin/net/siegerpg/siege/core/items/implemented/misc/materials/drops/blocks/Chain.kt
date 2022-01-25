package net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Chain() : CustomMaterial(
		name = "Chain",
		customModelData = 320007,
		description = listOf("A strong metal rope"),
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

		fun tier(tier : Int) : Chain {
			val newItem = Chain(0)
			newItem.tier = tier
			return newItem
		}
	}

}