package net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class RawHealthGem() : StatGemType(
		name = "Raw Health Gem",
		customModelData = 510001,
		description = listOf("A raw gem with untapped power"),
		levelRequirement = 4,
		material = Material.POPPED_CHORUS_FRUIT,

		statType = StatTypes.HEALTH,
		statAmount = 8.0
                                  ) {

	constructor(quality : Int) : this() {
		this.quality = 0
		this.rarity = Rarity.COMMON
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}