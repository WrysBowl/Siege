package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ElvinGuards() : CustomLeggings(
		name = "Elvin Guards",
		customModelData = 1,
		description = listOf("Magical protection"),
		levelRequirement = 45,
		material = Material.CHAINMAIL_LEGGINGS,
		baseStats = CustomItemUtils.statMap(
				health = 60.0,
				luck = 50.0,
				strength = -20.0,
				defense = -150.0
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