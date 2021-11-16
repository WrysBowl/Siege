package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Handsaw() : CustomTool(
		name = "Handsaw",
		customModelData = 430009,
		description = listOf("Gives extra rewards, same speed as stone version"),
		levelRequirement = 32,
		material = Material.STONE_AXE,
		baseStats = CustomItemUtils.statMap(luck = 15.0),

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