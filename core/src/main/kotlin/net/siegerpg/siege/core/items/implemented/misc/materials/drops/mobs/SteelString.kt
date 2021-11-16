package net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SteelString() : CustomMaterial(
	name = "Steel String",
	customModelData = 310015,
	description = listOf("The sound of a bow", "with this string", "is very loud"),
	levelRequirement = 0,
	material = Material.FLINT,

	) {

	constructor(quality: Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

	companion object {

		fun tier(tier: Int): SteelString {
			val newItem = SteelString(0)
			newItem.tier = tier
			return newItem
		}
	}

}