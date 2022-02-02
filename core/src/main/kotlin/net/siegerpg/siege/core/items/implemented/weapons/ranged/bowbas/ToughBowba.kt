package net.siegerpg.siege.core.items.implemented.weapons.ranged.bowbas

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughBowba() : CustomBow(
		name = "Tough Bowba",
		customModelData = 120010,
		description = listOf("Bones fused with metal in the shape of a bow"),
		levelRequirement = 56,
		material = Material.BOW,
		baseStats = CustomItemUtils.statMap(
				strength = 45.0,
				luck = 13.0,
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