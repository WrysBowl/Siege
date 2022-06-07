package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class MagmaBoots() : CustomBoots(
		name = "Magma Boots",
		customModelData = 1,
		description = listOf("Some lit boots"),
		levelRequirement = 14,
		material = Material.LEATHER_BOOTS,
		baseStats = CustomItemUtils.statMap(health = 10.0, defense = 8.0, strength = 10.0),
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