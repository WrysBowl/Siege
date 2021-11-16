package net.siegerpg.siege.core.items.implemented.weapons.wands.glowingTwigs

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughGlowingTwig() : CustomWand(
	name = "Tough Glowing Twig",
	customModelData = 140003,
	description = listOf("A twig from the spirit world"),
	levelRequirement = 8,
	material = Material.WOODEN_HOE,
	baseStats = CustomItemUtils.statMap(strength = 8.0, luck = 5.0, toughness = 50.0),

	range = 12,
	red = 255,
	green = 255,
	blue = 153,
	damageRadius = 2.5
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