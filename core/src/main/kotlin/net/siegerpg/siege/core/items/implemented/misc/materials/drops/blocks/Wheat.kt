package net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Wheat() : CustomMaterial(
		name = "Wheat",
		customModelData = 320011,
		description = listOf("The most important", "part of bread"),
		levelRequirement = 0,
		material = Material.FLINT,
		upgradeStats = hashMapOf(
				4 to CustomItemUtils.statMap(regeneration = 0.2),
				5 to CustomItemUtils.statMap(regeneration = 2.0)
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

		fun tier(tier : Int) : Wheat {
			val newItem = Wheat(0)
			newItem.tier = tier
			return newItem
		}
	}

}