package net.siegerpg.siege.core.items.implemented.weapons.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Malice() : CustomWand(
		name = "Malice",
		customModelData = 140011,
		description = listOf("Cast your anger", "as a spell"),
		levelRequirement = 65,
		material = Material.WOODEN_HOE,
		baseStats = CustomItemUtils.statMap(strength = 60.0, health = -20.0),
		range = 32,
		red = 0,
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