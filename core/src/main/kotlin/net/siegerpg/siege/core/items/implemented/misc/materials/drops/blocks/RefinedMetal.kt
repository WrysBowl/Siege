package net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class RefinedMetal() : CustomMaterial(
		name = "Refined Metal",
		customModelData = 320009,
		description = listOf("Polished and shiny!"),
		levelRequirement = 0,
		material = Material.FLINT,
		upgradeStats = hashMapOf(
				4 to CustomItemUtils.statMap(toughness = 4.0, strength = 4.0),
				5 to CustomItemUtils.statMap(toughness = 24.0, strength = 24.0)
		                        )
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

		fun tier(tier : Int) : RefinedMetal {
			val newItem = RefinedMetal(0)
			newItem.tier = tier
			return newItem
		}
	}

}