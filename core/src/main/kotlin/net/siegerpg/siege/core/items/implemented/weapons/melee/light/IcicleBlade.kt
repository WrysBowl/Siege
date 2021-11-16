package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class IcicleBlade() : CustomMeleeWeapon(
		name = "Icicle Blade",
		customModelData = 110012,
		description = listOf("Long", "hard", "and icy"),
		levelRequirement = 48,
		material = Material.WOODEN_SWORD,
		baseStats = CustomItemUtils.statMap(
				strength = 50.0,
				health = 40.0,
				toughness = 50.0,
				luck = -30.0
		                                   ),
		attackSpeed = 2.0
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