package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PixieDagger() : CustomMeleeWeapon(
	name = "Pixie Dagger",
	customModelData = 110013,
	description = listOf("It's an extremely", "sharp needle"),
	levelRequirement = 54,
	material = Material.WOODEN_SWORD,
	baseStats = CustomItemUtils.statMap(strength = 60.0, luck = 45.0, toughness = -150.0),
	attackSpeed = 1.7
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