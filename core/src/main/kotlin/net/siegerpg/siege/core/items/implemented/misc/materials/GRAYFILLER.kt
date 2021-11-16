package net.siegerpg.siege.core.items.implemented.misc.materials

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class GRAYFILLER() : CustomMaterial(
	name = "",
	description = listOf(""),
	material = Material.GRAY_STAINED_GLASS_PANE
                                   ) {

	constructor(quality: Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

}