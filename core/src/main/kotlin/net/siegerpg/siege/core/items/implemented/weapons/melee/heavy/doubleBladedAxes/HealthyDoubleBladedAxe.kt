package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.doubleBladedAxes

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyDoubleBladedAxe() : CustomMeleeWeapon(
		name = "Healthy Double Bladed Axe",
		customModelData = 130005,
		description = listOf("You're really only going to use one side"),
		levelRequirement = 19,
		material = Material.WOODEN_AXE,
		baseStats = CustomItemUtils.statMap(strength = 34.0, health = 6.0),
		attackSpeed = 0.7
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