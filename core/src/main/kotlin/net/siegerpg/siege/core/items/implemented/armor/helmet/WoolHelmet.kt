package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class WoolHelmet() : CustomHelmet(
		name = "Wool Helmet",
		customModelData = 1,
		description = listOf("Keep your ears warm"),
		levelRequirement = 8,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 12.0, defense = 10.0, strength = 2.0),
		leatherColor = Color.WHITE,
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