package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TestChestplate() : CustomChestplate(
		name = "Test Chestplate",
		customModelData = 1,
		description = listOf("A chestplate for testing"),
		levelRequirement = 0,
		material = Material.DIAMOND_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(strength = 10.0)
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