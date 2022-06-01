package net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomKey
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class RareKey() : CustomKey(
		name = "Cosmetic Key V",
		customModelData = 630003,
		description = listOf("Get a rare cosmetic"),
		material = Material.TRIPWIRE_HOOK,
		quality = 80
                           ) {
	override fun getSellValue() : Int {
		return 12500
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