package net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Coal() : CustomMaterial(
		name = "Coal",
		customModelData = 320003,
		description = listOf("Burned to gain energy resource"),
		levelRequirement = 0,
		material = Material.FLINT,
		upgradeStats = hashMapOf(
				2 to CustomItemUtils.statMap(luck = 0.2),
				3 to CustomItemUtils.statMap(luck = 2.0),
				4 to CustomItemUtils.statMap(luck = 8.0),
				5 to CustomItemUtils.statMap(luck = 32.0)
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

		fun tier(tier : Int) : Coal {
			val newItem = Coal(0)
			newItem.tier = tier
			return newItem
		}
	}

}