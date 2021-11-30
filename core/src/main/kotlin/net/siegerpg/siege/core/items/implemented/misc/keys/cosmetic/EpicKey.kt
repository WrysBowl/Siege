package net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomKey
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class EpicKey() : CustomKey(
		name = "Epic Key",
		customModelData = 630004,
		description = listOf("Get an epic cosmetic", "Use in the hub"),
		material = Material.TRIPWIRE_HOOK,
                           ) {

	constructor(quality : Int) : this() {
		this.quality = 90
		this.rarity = Rarity.EPIC
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}