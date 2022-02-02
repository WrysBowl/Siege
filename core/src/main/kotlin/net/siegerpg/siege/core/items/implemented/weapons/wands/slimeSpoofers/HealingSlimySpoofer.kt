package net.siegerpg.siege.core.items.implemented.weapons.wands.slimeSpoofers

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingSlimySpoofer() : CustomWand(
		name = "Healing Slime Spoofer",
		customModelData = 140004,
		description = listOf("Made from the life force of slimes"),
		levelRequirement = 18,
		material = Material.WOODEN_HOE,
		baseStats = CustomItemUtils.statMap(
				strength = 9.0,
				luck = 5.0,
				regeneration = 6.0
		                                   ),

		range = 10,
		red = 153,
		green = 255,
		blue = 51,
		damageRadius = 2.0
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