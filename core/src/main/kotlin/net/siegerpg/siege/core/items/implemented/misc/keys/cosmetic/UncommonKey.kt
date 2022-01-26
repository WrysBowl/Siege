package net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomKey
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class UncommonKey() : CustomKey(
		name = "Uncommon Key",
		customModelData = 630002,
		description = listOf("Get an uncommon cosmetic"),
		material = Material.TRIPWIRE_HOOK,
		quality = 50
                               ) {
	override fun getSellValue() : Int {
		return 5000
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