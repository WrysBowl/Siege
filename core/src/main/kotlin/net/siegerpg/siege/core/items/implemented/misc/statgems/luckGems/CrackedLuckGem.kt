package net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CrackedLuckGem() : StatGemType(
		name = "Cracked Luck Gem",
		customModelData = 520003,
		description = listOf("Most of it's power has been leaked"),
		levelRequirement = 8,
		material = Material.POPPED_CHORUS_FRUIT,

		statType = StatTypes.LUCK,
		statAmount = 6.0
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