package net.siegerpg.siege.core.items.implemented.armor.helmet.magmaHelmets

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughMagmaHelmet() : CustomHelmet(
		name = "Tough Magma Helmet",
		customModelData = 1,
		description = listOf("Quite the hot head"),
		levelRequirement = 17,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 8.0, defense = 23.0),
		leatherColor = Color.ORANGE,
		gearSetInfo = listOf(listOf("Have a 30% chance to burn attackers"))
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