package net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomKey
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SpiritKey() : CustomKey(
		name = "Spirit Key",
		customModelData = 630008,
		description = listOf("High chance of a", "legendary cosmetic", "Use in the hub"),
		material = Material.TRIPWIRE_HOOK,
                             ) {

	constructor(quality : Int) : this() {
		this.quality = 100
		this.rarity = Rarity.LEGENDARY
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}