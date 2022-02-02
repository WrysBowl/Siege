package net.siegerpg.siege.core.items.implemented.weapons.ranged.recurveBows

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyRecurveBow() : CustomBow(
		name = "Healthy Recurve Bow",
		customModelData = 120007,
		description = listOf(
				"Slight curves at the ends",
				"give the bow a bit more power"
		                    ),
		levelRequirement = 35,
		material = Material.BOW,
		baseStats = CustomItemUtils.statMap(strength = 30.0, luck = 8.0, health = 20.0),
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