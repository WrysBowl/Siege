package net.siegerpg.siege.core.items.implemented.weapons.wands.flamingHotTorches

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingFlamingHotTorch() : CustomWand(
		name = "Healing Flaming Hot Torch",
		customModelData = 140007,
		description = listOf(
				"This weapon was said to have the ability",
				"to generate mass amounts of electricity"
		                    ),
		levelRequirement = 37,
		material = Material.WOODEN_HOE,
		baseStats = CustomItemUtils.statMap(
				strength = 18.0,
				luck = 12.0,
				regeneration = 7.0
		                                   ),

		range = 19,
		red = 255,
		green = 0,
		blue = 0,
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