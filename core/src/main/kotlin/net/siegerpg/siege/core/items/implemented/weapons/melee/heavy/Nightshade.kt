package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Nightshade() : CustomMeleeWeapon(
		name = "Nightshade",
		customModelData = 130011,
		description = listOf("Strike with the", "might of the night"),
		levelRequirement = 44,
		material = Material.WOODEN_AXE,
		baseStats = CustomItemUtils.statMap(
				strength = 100.0,
				regeneration = -20.0,
				luck = -25.0
		                                   ),
		attackSpeed = 0.8
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