package net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PristineHealthGem() : StatGemType(
	name = "Pristine Health Gem",
	customModelData = 560001,
	description = listOf("Power radiates from the core of this gem"),
	levelRequirement = 35,
	material = Material.POPPED_CHORUS_FRUIT,

	statType = StatTypes.HEALTH,
	statAmount = 22.0
                                       ) {

	constructor(quality: Int) : this() {
		this.quality = 0
		this.rarity = Rarity.COMMON
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

}