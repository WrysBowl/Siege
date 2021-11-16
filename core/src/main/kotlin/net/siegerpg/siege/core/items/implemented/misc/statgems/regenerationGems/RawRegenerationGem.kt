package net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class RawRegenerationGem() : StatGemType(
	name = "Raw Regeneration Gem",
	customModelData = 510005,
	description = listOf("A raw gem with untapped power"),
	levelRequirement = 4,
	material = Material.POPPED_CHORUS_FRUIT,

	statType = StatTypes.REGENERATION,
	statAmount = 4.0
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