package net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SimpleToughGem() : StatGemType(
	name = "Simple Tough Gem",
	customModelData = 540004,
	description = listOf("A simple gem"),
	levelRequirement = 20,
	material = Material.POPPED_CHORUS_FRUIT,

	statType = StatTypes.TOUGHNESS,
	statAmount = 30.0
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