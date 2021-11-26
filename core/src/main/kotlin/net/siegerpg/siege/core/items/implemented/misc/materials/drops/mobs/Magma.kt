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
				2 to CustomItemUtils.statMap(health = 0.1, strength = 0.2),
				3 to CustomItemUtils.statMap(health = 1.0, strength = 2.0),
				4 to CustomItemUtils.statMap(health = 4.0, strength = 8.0),
				5 to CustomItemUtils.statMap(health = 16.0, strength = 32.0)
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