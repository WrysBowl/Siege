package net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class RawStrengthGem() : StatGemType(
		name = "Raw Strength Gem",
		customModelData = 510002,
		description = listOf("A raw gem with untapped power"),
		levelRequirement = 4,
		material = Material.POPPED_CHORUS_FRUIT,

		statType = StatTypes.STRENGTH,
		statAmount = 2.0,
		quality = 0
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

}