package net.siegerpg.siege.core.items.implemented.weapons.ranged.sewerShooters

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthySewerShooter() : CustomBow(
	name = "Healthy Sewer Shooter",
	customModelData = 120005,
	description = listOf("A bow made of mob flesh,", "that's a first"),
	levelRequirement = 22,
	material = Material.BOW,
	baseStats = CustomItemUtils.statMap(strength = 24.0, health = 14.0),
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