package net.siegerpg.siege.core.items.implemented.armor.helmet.strawHelmets

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyStrawHat() : CustomHelmet(
		name = "Healthy Straw Hat",
		customModelData = 1,
		description = listOf("Farmer"),
		levelRequirement = 3,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 10.0, regeneration = 2.0),
		leatherColor = Color.YELLOW
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