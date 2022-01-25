package net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomKey
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class FoxSpiritKey() : CustomKey(
		name = "Fox Spirit Key",
		customModelData = 620004,
		description = listOf("Used to summon", "the Fox spirit"),
		material = Material.TRIPWIRE_HOOK,
		quality = 90,

                                ) {
	override fun getSellValue() : Int {
		return 10000
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