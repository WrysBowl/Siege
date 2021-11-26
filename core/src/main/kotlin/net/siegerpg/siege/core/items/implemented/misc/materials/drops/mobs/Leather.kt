package net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Leather() : CustomMaterial(
		name = "Leather",
		customModelData = 310006,
		description = listOf("Animal hide"),
		levelRequirement = 0,
		material = Material.FLINT,
		upgradeStats = hashMapOf(
				2 to CustomItemUtils.statMap(toughness = 0.2),
				3 to CustomItemUtils.statMap(toughness = 1.6),
				4 to CustomItemUtils.statMap(toughness = 8.0),
				5 to CustomItemUtils.statMap(toughness = 24.0)
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

		fun tier(tier : Int) : Leather {
			val newItem = Leather(0)
			newItem.tier = tier
			return newItem
		}
	}

}