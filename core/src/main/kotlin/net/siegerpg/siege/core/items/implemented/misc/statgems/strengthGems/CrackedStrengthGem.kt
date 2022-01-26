package net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CrackedStrengthGem() : StatGemType(
		name = "Cracked Strength Gem",
		customModelData = 520002,
		description = listOf("Most of it's power has been leaked"),
		levelRequirement = 8,
		material = Material.POPPED_CHORUS_FRUIT,

		statType = StatTypes.STRENGTH,
		statAmount = 3.0,
		quality = 50
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