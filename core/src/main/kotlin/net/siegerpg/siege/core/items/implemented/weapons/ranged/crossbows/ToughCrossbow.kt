package net.siegerpg.siege.core.items.implemented.weapons.ranged.crossbows

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughCrossbow() : CustomBow(
		name = "Tough Crossbow",
		customModelData = 0,
		description = listOf("The OG pistol"),
		levelRequirement = 28,
		material = Material.CROSSBOW,
		baseStats = CustomItemUtils.statMap(
				strength = 26.0,
				luck = 6.0,
				defense = 80.0
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