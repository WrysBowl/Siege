package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Marrow() : CustomBow(
		name = "Marrow",
		customModelData = 120011,
		description = listOf("Made from the best", "part of the bone"),
		levelRequirement = 43,
		material = Material.BOW,
		baseStats = CustomItemUtils.statMap(
				strength = 70.0,
				regeneration = 30.0,
				health = -30.0,
				defense = -100.0
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