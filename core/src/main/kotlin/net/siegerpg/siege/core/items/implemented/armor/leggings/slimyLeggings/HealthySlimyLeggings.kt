package net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthySlimyLeggings() : CustomLeggings(
	name = "Healthy Slimy Leggings",
	customModelData = 1,
	description = listOf("Waste high in sewage"),
	levelRequirement = 4,
	material = Material.LEATHER_LEGGINGS,
	baseStats = CustomItemUtils.statMap(health = 14.0),
	leatherColor = Color.LIME
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