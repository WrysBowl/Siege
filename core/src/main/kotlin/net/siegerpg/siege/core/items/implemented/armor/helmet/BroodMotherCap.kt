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
		description = listOf("The Brood Mother is the eigth guardian"),
		levelRequirement = 50,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 150.0, defense = 75.0, strength = 25.0, regeneration = -30.0),
		gearSetInfo = listOf(listOf("Sneak to set a trap that spawns a poison cloud when stepped on (and slows mob/player)")),
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