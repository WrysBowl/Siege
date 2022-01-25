package net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomKey
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LichKey() : CustomKey(
		name = "Lich Key",
		customModelData = 620009,
		description = listOf("Used to summon", "the Lich"),
		material = Material.TRIPWIRE_HOOK,
		quality = 50,
		sellCost = 4000
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