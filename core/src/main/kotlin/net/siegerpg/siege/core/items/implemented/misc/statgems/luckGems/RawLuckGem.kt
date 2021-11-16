package net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class RawLuckGem() : StatGemType(
		name = "Raw Luck Gem",
		customModelData = 510003,
		description = listOf("A raw gem with untapped power"),
		levelRequirement = 4,
		material = Material.POPPED_CHORUS_FRUIT,

		statType = StatTypes.LUCK,
		statAmount = 4.0
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