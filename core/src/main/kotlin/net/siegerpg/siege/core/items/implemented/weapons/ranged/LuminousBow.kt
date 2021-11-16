package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuminousBow() : CustomBow(
	name = "Luminous Bow",
	customModelData = 120012,
	description = listOf("A glowy bow"),
	levelRequirement = 48,
	material = Material.BOW,
	baseStats = CustomItemUtils.statMap(
		strength = 75.0,
		regeneration = 10.0,
		health = 40.0,
		luck = -30.0,
		toughness = -100.0
	)
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