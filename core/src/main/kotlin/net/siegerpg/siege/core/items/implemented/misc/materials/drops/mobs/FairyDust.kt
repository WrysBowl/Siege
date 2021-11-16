package net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class FairyDust() : CustomMaterial(
	name = "Fairy Dust",
	customModelData = 310009,
	description = listOf("A bright powder that", "has magical properties"),
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

		fun tier(tier: Int): FairyDust {
			val newItem = FairyDust(0)
			newItem.tier = tier
			return newItem
		}
	}

}