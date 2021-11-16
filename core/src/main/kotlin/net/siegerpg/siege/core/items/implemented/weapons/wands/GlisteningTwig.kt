package net.siegerpg.siege.core.items.implemented.weapons.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class GlisteningTwig() : CustomWand(
		name = "Glistening Twig",
		customModelData = 140002,
		description = listOf("A dead twig reborn"),
		levelRequirement = 6,
		material = Material.WOODEN_HOE,
		baseStats = CustomItemUtils.statMap(strength = 8.0, luck = 6.0),
		range = 12,
		red = 255,
		green = 255,
		blue = 153,
		damageRadius = 2.5
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