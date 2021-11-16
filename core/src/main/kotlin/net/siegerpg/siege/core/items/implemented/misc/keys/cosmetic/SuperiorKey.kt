package net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomKey
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SuperiorKey() : CustomKey(
	name = "Superior Key",
	customModelData = 630007,
	description = listOf("High chance of a", "rare cosmetic"),
	material = Material.TRIPWIRE_HOOK,
                               ) {

	constructor(quality: Int) : this() {
		this.quality = 80
		this.rarity = Rarity.RARE
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

}