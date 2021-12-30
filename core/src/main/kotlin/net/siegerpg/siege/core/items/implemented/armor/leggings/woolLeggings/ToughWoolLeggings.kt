package net.siegerpg.siege.core.items.implemented.armor.leggings.woolLeggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughWoolLeggings() : CustomLeggings(
		name = "Tough Wool Leggings",
		customModelData = 1,
		description = listOf("Dressed for the winter"),
		levelRequirement = 9,
		material = Material.LEATHER_LEGGINGS,
		baseStats = CustomItemUtils.statMap(health = 5.0, defense = 17.0),
		leatherColor = Color.WHITE
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