package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Illumina() : CustomMeleeWeapon(
		name = "Illumina",
		customModelData = 110014,
		description = listOf("It's an extremely", "sharp needle"),
		levelRequirement = 60,
		material = Material.WOODEN_SWORD,
		baseStats = CustomItemUtils.statMap(
				strength = 80.0,
				luck = 20.0,
				regeneration = -20.0,
				defense = -50.0
		                                   ),
		attackSpeed = 1.4
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