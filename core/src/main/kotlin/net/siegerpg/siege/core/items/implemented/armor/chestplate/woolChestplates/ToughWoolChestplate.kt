package net.siegerpg.siege.core.items.implemented.armor.chestplate.woolChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughWoolChestplate() : CustomChestplate(
	name = "Tough Wool Chestplate",
	customModelData = 1,
	description = listOf("A cotton jacket"),
	levelRequirement = 9,
	material = Material.LEATHER_CHESTPLATE,
	baseStats = CustomItemUtils.statMap(health = 5.0, toughness = 60.0),
	leatherColor = Color.WHITE
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