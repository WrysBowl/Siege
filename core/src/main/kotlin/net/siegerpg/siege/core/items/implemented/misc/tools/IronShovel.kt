package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class IronShovel() : CustomTool(
		name = "Iron Shovel",
		customModelData = 420007,
		description = listOf("Industrializing!"),
		levelRequirement = 23,
		material = Material.IRON_SHOVEL,
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