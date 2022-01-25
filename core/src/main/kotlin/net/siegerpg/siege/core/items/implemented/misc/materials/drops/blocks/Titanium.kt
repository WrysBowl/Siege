package net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Titanium() : CustomMaterial(
		name = "Titanium",
		customModelData = 320010,
		description = listOf("Even better metal"),
		levelRequirement = 0,
		material = Material.FLINT,
		) {
	override fun getSellValue() : Int {
		return 500
	}
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

		fun tier(tier : Int) : Titanium {
			val newItem = Titanium(0)
			newItem.tier = tier
			return newItem
		}
	}

}