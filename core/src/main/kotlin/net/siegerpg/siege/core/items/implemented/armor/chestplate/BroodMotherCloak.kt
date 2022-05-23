package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BroodMotherCloak() : CustomChestplate(
		name = "Brood Mother's Cloak",
		customModelData = 1,
		description = listOf("The Brood Mother is the eighth guardian"),
		levelRequirement = 50,
		material = Material.LEATHER_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 170.0, defense = 85.0, strength = -70.0, regeneration = 55.0),
		gearSetInfo = listOf("Sneak to shoot a beam of energy"),
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