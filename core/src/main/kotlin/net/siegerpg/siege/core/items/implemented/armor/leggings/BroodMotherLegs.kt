package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BroodMotherLegs() : CustomLeggings(
	name = "Brood Mother's Cloak",
	customModelData = 1,
	description = listOf("The Brood Mother is the eighth guardian"),
	levelRequirement = 50,
	material = Material.LEATHER_LEGGINGS,
	baseStats = CustomItemUtils.statMap(health = -100.0, defense = 170.0, strength = 65.0, regeneration = 50.0, luck = 35.0),
	gearSetInfo = listOf(listOf("Sneak to shoot a beam of energy")),
	leatherColor = Color.GREEN
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