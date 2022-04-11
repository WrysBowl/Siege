package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BoomiesHorns() : CustomHelmet(
		name = "Boomie's Horns",
		customModelData = 1,
		description = listOf("The Bull Spirit is the third guardian"),
		levelRequirement = 24,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 40.0, defense = 60.0, strength = 10.0, luck = -10.0),
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