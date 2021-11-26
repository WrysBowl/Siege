package net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Feather() : CustomMaterial(
		name = "Feather",
		customModelData = 310007,
		description = listOf("Ticklish?"),
		levelRequirement = 0,
		material = Material.FLINT,
		upgradeStats = hashMapOf(
				2 to CustomItemUtils.statMap(luck = 0.1),
				3 to CustomItemUtils.statMap(luck = 1.0),
				4 to CustomItemUtils.statMap(luck = 4.0),
				5 to CustomItemUtils.statMap(luck = 16.0)
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

		fun tier(tier : Int) : Feather {
			val newItem = Feather(0)
			newItem.tier = tier
			return newItem
		}
	}

}