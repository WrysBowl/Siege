package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TwilightStorm() : CustomBow(
		name = "Twilight Storm",
		customModelData = 120014,
		description = listOf("Never misses if you", "are skilled enough"),
		levelRequirement = 84,
		material = Material.BOW,
		baseStats = CustomItemUtils.statMap(
				strength = 110.0,
				luck = -15.0,
				health = -20.0
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