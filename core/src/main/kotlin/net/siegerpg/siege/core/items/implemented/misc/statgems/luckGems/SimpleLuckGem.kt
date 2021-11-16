package net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SimpleLuckGem() : StatGemType(
		name = "Simple Luck Gem",
		customModelData = 540003,
		description = listOf("A simple gem"),
		levelRequirement = 20,
		material = Material.POPPED_CHORUS_FRUIT,

		statType = StatTypes.LUCK,
		statAmount = 11.0
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