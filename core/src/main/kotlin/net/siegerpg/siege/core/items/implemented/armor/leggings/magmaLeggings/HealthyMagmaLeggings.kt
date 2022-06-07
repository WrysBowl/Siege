package net.siegerpg.siege.core.items.implemented.armor.leggings.magmaLeggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyMagmaLeggings() : CustomLeggings(
		name = "Healthy Magma Leggings",
		customModelData = 1,
		description = listOf("Burning fashion. Quite literally"),
		levelRequirement = 14,
		material = Material.LEATHER_LEGGINGS,
		baseStats = CustomItemUtils.statMap(health = 26.0, defense = 18.0),
		leatherColor = Color.ORANGE,
		gearSetInfo = listOf("Have a 30% chance to burn attackers")
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