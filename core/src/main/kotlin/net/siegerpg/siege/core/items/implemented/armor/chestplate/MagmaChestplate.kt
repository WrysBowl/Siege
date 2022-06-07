package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class MagmaChestplate() : CustomChestplate(
		name = "Magma Chestplate",
		customModelData = 1,
		description = listOf("This really warms my heart"),
		levelRequirement = 14,
		material = Material.LEATHER_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 25.0, defense = 15.0, strength = 5.0),
		leatherColor = Color.ORANGE,
		gearSetInfo = listOf("Have a 30% chance to burn attackers")
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