package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class GlacierParka() : CustomChestplate(
		name = "Glacier Parka",
		customModelData = 1,
		description = listOf("Keeps you warm", "from the cold"),
		levelRequirement = 55,
		material = Material.LEATHER_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(
				health = 350.0,
				regeneration = 70.0,
				strength = 35.0,
				luck = -35.0,
				toughness = -320.0
		                                   ),
		leatherColor = Color.AQUA
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