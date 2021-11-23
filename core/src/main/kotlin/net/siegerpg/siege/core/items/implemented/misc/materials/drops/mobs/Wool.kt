package net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Wool() : CustomMaterial(
		name = "Wool",
		customModelData = 310005,
		description = listOf("A ball of fluff to keep you warm"),
		levelRequirement = 0,
		material = Material.FLINT,
		upgradeStats = hashMapOf(
				4 to CustomItemUtils.statMap(regeneration = 1.0),
				5 to CustomItemUtils.statMap(regeneration = 10.0)
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

		fun tier(tier : Int) : Wool {
			val newItem = Wool(0)
			newItem.tier = tier
			return newItem
		}
	}

}