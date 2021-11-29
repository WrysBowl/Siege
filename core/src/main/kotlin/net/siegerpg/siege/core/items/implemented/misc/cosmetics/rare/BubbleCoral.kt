package net.siegerpg.siege.core.items.implemented.misc.cosmetics.rare

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BubbleCoral() : Cosmetic(
		name = "Bubble Coral",
		customModelData = 1,
		description = listOf(""),
		material = Material.BUBBLE_CORAL_BLOCK,
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