package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TestBoots() : CustomBoots(
	name = "Test Boots",
	customModelData = 1,
	description = listOf("Boots for testing"),
	levelRequirement = 0,
	material = Material.DIAMOND_BOOTS,
	baseStats = CustomItemUtils.statMap(strength = 10.0)
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