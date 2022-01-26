package net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PristineLuckGem() : StatGemType(
		name = "Pristine Luck Gem",
		customModelData = 560003,
		description = listOf("Power radiates from the core of this gem"),
		levelRequirement = 35,
		material = Material.POPPED_CHORUS_FRUIT,

		statType = StatTypes.LUCK,
		statAmount = 18.0,
		quality = 100
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