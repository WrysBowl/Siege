package net.siegerpg.siege.core.items.implemented.armor.leggings.hardenedLeatherLeggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyHardenedLeatherLeggings() : CustomLeggings(
		name = "Healthy Hardened Leather Leggings",
		customModelData = 1,
		description = listOf("Leather but erect"),
		levelRequirement = 18,
		material = Material.LEATHER_LEGGINGS,
		baseStats = CustomItemUtils.statMap(health = 25.0, regeneration = 5.0),
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