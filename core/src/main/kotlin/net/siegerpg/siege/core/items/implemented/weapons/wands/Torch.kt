package net.siegerpg.siege.core.items.implemented.weapons.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Torch() : CustomWand(
		name = "Torch",
		customModelData = 140006,
		description = listOf("Ancient magic of the ancestors"),
		levelRequirement = 19,
		material = Material.WOODEN_HOE,
		baseStats = CustomItemUtils.statMap(strength = 22.0, luck = 10.0),
		range = 19,
		red = 255,
		green = 153,
		blue = 51,
		damageRadius = 2.0
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