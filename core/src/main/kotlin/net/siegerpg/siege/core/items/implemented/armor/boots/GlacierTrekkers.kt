package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class GlacierTrekkers() : CustomBoots(
	name = "Glacier Trekkers",
	customModelData = 1,
	description = listOf("Tennis racket boots"),
	levelRequirement = 54,
	material = Material.LEATHER_BOOTS,
	baseStats = CustomItemUtils.statMap(
		health = 100.0,
		regeneration = 10.0,
		strength = 15.0,
		toughness = -100.0
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