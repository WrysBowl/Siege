package net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PlantMatter() : CustomMaterial(
		name = "Plant Matter",
		customModelData = 320001,
		description = listOf("Parts of a plant"),
		levelRequirement = 0,
		material = Material.FLINT,
		upgradeStats = hashMapOf(
				2 to CustomItemUtils.statMap(health = 0.2),
				3 to CustomItemUtils.statMap(health = 2.0),
				4 to CustomItemUtils.statMap(health = 6.0),
				5 to CustomItemUtils.statMap(health = 24.0)
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

		fun tier(tier : Int) : PlantMatter {
			val newItem = PlantMatter(0)
			newItem.tier = tier
			return newItem
		}
	}
}