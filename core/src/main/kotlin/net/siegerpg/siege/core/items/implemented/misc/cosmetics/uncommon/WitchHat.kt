package net.siegerpg.siege.core.items.implemented.misc.cosmetics.uncommon

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class WitchHat() : Cosmetic(
		name = "Witch Hat",
		customModelData = 720006,
		description = listOf(""),
		material = Material.KNOWLEDGE_BOOK,
                           ) {

	constructor(quality : Int) : this() {
		this.quality = 50
		this.rarity = Rarity.UNCOMMON
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}