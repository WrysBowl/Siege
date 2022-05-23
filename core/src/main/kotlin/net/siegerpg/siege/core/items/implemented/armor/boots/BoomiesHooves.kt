package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BoomiesHooves() : CustomBoots(
		name = "Boomie's Hooves",
		customModelData = 1,
		description = listOf("The Bull Spirit is the third guardian"),
		levelRequirement = 24,
		material = Material.LEATHER_BOOTS,
		baseStats = CustomItemUtils.statMap(health = 15.0, defense = 60.0, strength = 25.0),
		gearSetInfo = listOf("Sneak to charge forwards")
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