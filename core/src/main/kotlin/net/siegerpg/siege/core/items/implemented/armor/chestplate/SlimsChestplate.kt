package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SlimsChestplate() : CustomChestplate(
		name = "Slim's Chestplate",
		customModelData = 1,
		description = listOf("The Slime Spirit is the first guardian"),
		levelRequirement = 7,
		material = Material.LEATHER_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 24.0, defense = -20.0, strength = 16.0, luck = 10.0),
		leatherColor = Color.LIME,
		gearSetInfo = listOf("Double jump to jump forwards")
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