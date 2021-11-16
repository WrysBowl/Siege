package net.siegerpg.siege.core.items.implemented.weapons.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TestWand() : CustomWand(
		name = "Test Wand",
		customModelData = 1,
		description = listOf("A wand for testing"),
		levelRequirement = 0,
		material = Material.WOODEN_HOE,
		baseStats = CustomItemUtils.statMap(strength = 30.0),
		range = 15,
		red = 100,
		green = 100,
		blue = 100,
		damageRadius = 3.5
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