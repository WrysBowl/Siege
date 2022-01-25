package net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Slime() : CustomMaterial(
		name = "Slime",
		customModelData = 310001,
		description = listOf("Not jello?"),
		levelRequirement = 0,
		material = Material.FLINT,
		sellCost = 5
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

		fun tier(tier : Int) : Slime {
			val newItem = Slime(0)
			newItem.tier = tier
			return newItem
		}
	}

}