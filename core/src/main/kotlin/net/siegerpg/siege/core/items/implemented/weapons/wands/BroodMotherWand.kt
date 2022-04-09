package net.siegerpg.siege.core.items.implemented.weapons.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BroodMotherWand() : CustomWand(
		name = "Brood Mother's Wand",
		customModelData = 140010,
		description = listOf("Yucky!"),
		levelRequirement = 1,
		material = Material.WOODEN_HOE,
		baseStats = CustomItemUtils.statMap(strength = 50.0),
		range = 40,
		red = 50,
		green = 125,
		blue = 50,
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