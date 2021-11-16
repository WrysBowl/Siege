package net.siegerpg.siege.core.items.implemented.armor.chestplate.hardenedLeatherChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyHardenedLeatherChestplate() : CustomChestplate(
	name = "Healthy Hardened Leather Chestplate",
	customModelData = 1,
	description = listOf("Skin tight. Literally."),
	levelRequirement = 18,
	material = Material.LEATHER_CHESTPLATE,
	baseStats = CustomItemUtils.statMap(health = 30.0, toughness = 20.0),
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