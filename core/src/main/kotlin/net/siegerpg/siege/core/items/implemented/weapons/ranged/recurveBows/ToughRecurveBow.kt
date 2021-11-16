package net.siegerpg.siege.core.items.implemented.weapons.ranged.recurveBows

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughRecurveBow() : CustomBow(
		name = "Tough Recurve Bow",
		customModelData = 120007,
		description = listOf(
				"Slight curves at the ends",
				"give the bow a bit more power"
		                    ),
		levelRequirement = 30,
		material = Material.BOW,
		baseStats = CustomItemUtils.statMap(
				strength = 28.0,
				luck = 8.0,
				toughness = 80.0
		                                   ),
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