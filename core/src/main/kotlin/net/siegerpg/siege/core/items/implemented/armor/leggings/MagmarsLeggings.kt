package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class MagmarsLeggings() : CustomLeggings(
		name = "Magmar's Leggings",
		customModelData = 1,
		description = listOf("The Magma Spirit is the second guardian"),
		levelRequirement = 17,
		material = Material.LEATHER_LEGGINGS,
		baseStats = CustomItemUtils.statMap(health = 30.0, defense = 25.0, strength = 20.0, regeneration = -15.0),
		leatherColor = Color.ORANGE,
		gearSetInfo = listOf(listOf("Sneak to send a heatwave outwards"))
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