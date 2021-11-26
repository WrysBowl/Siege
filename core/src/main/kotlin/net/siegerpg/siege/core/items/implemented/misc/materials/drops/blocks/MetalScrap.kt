package net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class MetalScrap() : CustomMaterial(
		name = "Metal Scrap",
		customModelData = 320008,
		description = listOf("Scrapped metal found underground"),
		levelRequirement = 0,
		material = Material.FLINT,
		upgradeStats = hashMapOf(
				2 to CustomItemUtils.statMap(toughness = 0.2, strength = 0.2),
				3 to CustomItemUtils.statMap(toughness = 2.0, strength = 2.0),
				4 to CustomItemUtils.statMap(toughness = 8.0, strength = 8.0),
				5 to CustomItemUtils.statMap(toughness = 32.0, strength = 32.0)
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

		fun tier(tier : Int) : MetalScrap {
			val newItem = MetalScrap(0)
			newItem.tier = tier
			return newItem
		}
	}

}