package net.siegerpg.siege.core.items.implemented.misc.cosmetics.epic

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SquidHead() : Cosmetic(
		name = "Squid Head",
		customModelData = 740002,
		description = listOf(""),
		material = Material.KNOWLEDGE_BOOK,
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