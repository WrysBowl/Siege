package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class WoodenShovel() : CustomTool(
		name = "Wooden Shovel",
		customModelData = 420001,
		description = listOf("Your basic shovel"),
		levelRequirement = 0,
		material = Material.WOODEN_SHOVEL,
		baseStats = CustomItemUtils.statMap(),

		enchantments = hashMapOf(
		                        )
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