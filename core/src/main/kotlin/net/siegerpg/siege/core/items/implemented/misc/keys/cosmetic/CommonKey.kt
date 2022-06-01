package net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomKey
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CommonKey() : CustomKey(
		name = "Cosmetic Key I",
		customModelData = 630001,
		description = listOf("Get a common cosmetic"),
		material = Material.TRIPWIRE_HOOK,
		quality = 0
                             ) {

	override fun getSellValue() : Int {
		return 1500
	}

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