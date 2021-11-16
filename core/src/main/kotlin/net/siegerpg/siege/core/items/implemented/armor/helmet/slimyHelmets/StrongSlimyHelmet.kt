package net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongSlimyHelmet() : CustomHelmet(
	name = "Strong Slimy Helmet",
	customModelData = 1,
	description = listOf("So this is what it feels", "like to be a slime"),
	levelRequirement = 3,
	material = Material.LEATHER_HELMET,
	baseStats = CustomItemUtils.statMap(health = 2.0, toughness = 2.0, strength = 3.0),
	leatherColor = Color.LIME
) {

	constructor(quality: Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

}