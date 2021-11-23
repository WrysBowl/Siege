package net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Magma() : CustomMaterial(
		name = "Magma",
		customModelData = 310002,
		description = listOf("Melted slime"),
		levelRequirement = 0,
		material = Material.FLINT,
		upgradeStats = hashMapOf(
				4 to CustomItemUtils.statMap(health = 1.0, strength = 1.2),
				5 to CustomItemUtils.statMap(health = 8.0, strength = 12.0)
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

		fun tier(tier : Int) : Magma {
			val newItem = Magma(0)
			newItem.tier = tier
			return newItem
		}
	}
}