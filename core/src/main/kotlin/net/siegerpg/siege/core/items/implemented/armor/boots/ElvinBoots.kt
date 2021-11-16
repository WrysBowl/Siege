package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ElvinBoots() : CustomBoots(
	name = "Elvin Boots",
	customModelData = 1,
	description = listOf("Click clack", "guess who's back"),
	levelRequirement = 44,
	material = Material.IRON_BOOTS,
	baseStats = CustomItemUtils.statMap(
		health = 50.0,
		luck = 25.0,
		regeneration = -10.0,
		strength = -15.0
	),
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