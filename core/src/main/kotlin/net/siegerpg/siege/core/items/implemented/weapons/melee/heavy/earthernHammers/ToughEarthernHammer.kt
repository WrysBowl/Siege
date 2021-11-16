package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.earthernHammers

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughEarthernHammer() : CustomMeleeWeapon(
	name = "Tough Earthern Hammer",
	customModelData = 130010,
	description = listOf("Let's go clobbing!"),
	levelRequirement = 39,
	material = Material.WOODEN_AXE,
	baseStats = CustomItemUtils.statMap(strength = 65.0, toughness = 50.0),
	attackSpeed = 0.7
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