package net.siegerpg.siege.core.items.implemented.weapons.melee.light

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CursedSickle() : CustomMeleeWeapon(
		name = "Cursed Sickle",
		customModelData = 110011,
		description = listOf("For harvesting...", "souls!"),
		levelRequirement = 43,
		material = Material.WOODEN_SWORD,
		baseStats = CustomItemUtils.statMap(
				strength = 40.0,
				regeneration = 15.0,
				luck = 20.0,
				toughness = -100.0
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