package net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Pebble() : CustomMaterial(
		name = "Pebble",
		customModelData = 320006,
		description = listOf("Tiny bits of rock"),
		levelRequirement = 0,
		material = Material.FLINT,
		upgradeStats = hashMapOf(
				2 to CustomItemUtils.statMap(toughness = 0.1),
				3 to CustomItemUtils.statMap(toughness = 1.0),
				4 to CustomItemUtils.statMap(toughness = 4.0),
				5 to CustomItemUtils.statMap(toughness = 16.0)
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

		fun tier(tier : Int) : Pebble {
			val newItem = Pebble(0)
			newItem.tier = tier
			return newItem
		}
	}

}