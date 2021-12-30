package net.siegerpg.siege.core.items.implemented.armor.helmet.hardenedLeatherHelmets

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingHardenedLeatherHelmet() : CustomHelmet(
		name = "Healing Hardened Leather Helmet",
		customModelData = 1,
		description = listOf("Cow Hat"),
		levelRequirement = 17,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 8.0, defense = 15.0, regeneration = 22.0),
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