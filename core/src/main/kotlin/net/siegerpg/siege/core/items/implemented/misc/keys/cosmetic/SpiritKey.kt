package net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomKey
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SpiritKey() : CustomKey(
		name = "Spirit Key",
		customModelData = 630008,
		description = listOf("High chance of an", "epic cosmetic"),
		material = Material.TRIPWIRE_HOOK,
		quality = 100
                             ) {
	override fun getSellValue() : Int {
		return 20000
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