package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class MagmaHelmet() : CustomHelmet(
		name = "Magma Helmet",
		customModelData = 1,
		description = listOf("Quite the hot head"),
		levelRequirement = 12,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 15.0, toughness = 14.0),
		leatherColor = Color.ORANGE
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