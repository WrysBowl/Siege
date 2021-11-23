package net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Bone() : CustomMaterial(
		name = "Bone",
		customModelData = 310004,
		description = listOf("Remains of a once living animal"),
		levelRequirement = 0,
		material = Material.FLINT,
		upgradeStats = hashMapOf(
				4 to CustomItemUtils.statMap(health = 2.0, strength = 1.0),
				5 to CustomItemUtils.statMap(health = 16.0, strength = 10.0)
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

		fun tier(tier : Int) : Bone {
			val newItem = Bone(0)
			newItem.tier = tier
			return newItem
		}
	}

}