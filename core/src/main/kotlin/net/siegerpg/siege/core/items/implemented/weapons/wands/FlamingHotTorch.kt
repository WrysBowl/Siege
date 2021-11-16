package net.siegerpg.siege.core.items.implemented.weapons.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class FlamingHotTorch() : CustomWand(
	name = "Flaming Hot Torch",
	customModelData = 140007,
	description = listOf(
		"This weapon was said to have the ability",
		"to generate mass amounts of electricity"
	                    ),
	levelRequirement = 24,
	material = Material.WOODEN_HOE,
	baseStats = CustomItemUtils.statMap(strength = 24.0, luck = 16.0),
	range = 19,
	red = 255,
	green = 0,
	blue = 0,
	damageRadius = 2.0
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