package net.siegerpg.siege.core.items.implemented.weapons.wands.hotRods

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyHotRod() : CustomWand(
		name = "Healthy Hot Rod",
		customModelData = 140009,
		description = listOf(
				"A super heated rod of iron which",
				"can be directed to attackers!"
		                    ),
		levelRequirement = 33,
		material = Material.WOODEN_HOE,
		baseStats = CustomItemUtils.statMap(strength = 25.0, luck = 5.0, health = 7.0),

		range = 19,
		red = 204,
		green = 51,
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