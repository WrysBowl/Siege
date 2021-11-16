package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Shovel() : CustomMeleeWeapon(
	name = "Shovel",
	customModelData = 110004,
	description = listOf("A true grave digger"),
	levelRequirement = 13,
	material = Material.WOODEN_SWORD,
	baseStats = CustomItemUtils.statMap(strength = 17.0),
	attackSpeed = 1.5
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