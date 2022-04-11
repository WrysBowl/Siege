package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BroodMotherCap() : CustomHelmet(
		name = "Brood Mother's Cap",
		customModelData = 1,
		description = listOf("The Brood Mother is the eighth guardian"),
		levelRequirement = 50,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 150.0, defense = 75.0, strength = 25.0, regeneration = -30.0),
		gearSetInfo = listOf("Sneak to shoot a beam of energy"),
		leatherColor = Color.fromRGB(50, 125, 50)
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