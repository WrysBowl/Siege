package net.siegerpg.siege.core.items.implemented.weapons.ranged.pebbleShooters

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughPebbleShooter() : CustomBow(
		name = "Tough Pebble Shooter",
		customModelData = 120003,
		description = listOf("Now comes with pebble", "shooting support!"),
		levelRequirement = 10,
		material = Material.BOW,
		baseStats = CustomItemUtils.statMap(strength = 18.0, defense = 40.0),
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