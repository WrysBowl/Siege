package net.siegerpg.siege.core.items.implemented.misc.cosmetics.rare

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class IronBlock() : Cosmetic(
		name = "Iron Block",
		customModelData = 1,
		description = listOf(""),
		material = Material.IRON_BLOCK,
                            ) {

	constructor(quality : Int) : this() {
		this.quality = 80
		this.rarity = Rarity.RARE
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}