package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TitaniumHelmet() : CustomHelmet(
		name = "Titanium Helmet",
		customModelData = 1,
		description = listOf("Safety first!"),
		levelRequirement = 49,
		material = Material.IRON_HELMET,
		baseStats = CustomItemUtils.statMap(
				health = 50.0,
				defense = 125.0,
				regeneration = 79.0,
				strength = -20.0,
				luck = -15.0,
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