package net.siegerpg.siege.core.items.implemented.weapons.ranged.sewerShooters

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingSewerShooter() : CustomBow(
		name = "Healing Sewer Shooter",
		customModelData = 120005,
		description = listOf("A bow made of mob flesh,", "that's a first"),
		levelRequirement = 22,
		material = Material.BOW,
		baseStats = CustomItemUtils.statMap(
				strength = 23.0,
				luck = 5.0,
				regeneration = 9.0
		                                   ),
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