package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class GlacierLeggings() : CustomLeggings(
	name = "Glacier Leggings",
	customModelData = 1,
	description = listOf("Don't want to freeze", "anything important"),
	levelRequirement = 55,
	material = Material.LEATHER_LEGGINGS,
	baseStats = CustomItemUtils.statMap(
		health = 200.0,
		regeneration = 40.0,
		strength = 25.0,
		luck = -25.0,
		toughness = -225.0
	),
	leatherColor = Color.AQUA
) {

	constructor(quality: Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

}