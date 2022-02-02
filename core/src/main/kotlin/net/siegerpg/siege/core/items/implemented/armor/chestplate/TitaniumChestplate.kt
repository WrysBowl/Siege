package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TitaniumChestplate() : CustomChestplate(
		name = "Titanium Chestplate",
		customModelData = 1,
		description = listOf("One of the hardest", "materials known"),
		levelRequirement = 80,
		material = Material.IRON_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(
				defense = 300.0,
				strength = 150.0,
				regeneration = 15.0,
				health = -80.0,
				luck = -35.0,
		                                   ),
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