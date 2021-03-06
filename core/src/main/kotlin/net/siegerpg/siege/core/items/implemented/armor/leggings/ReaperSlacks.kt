package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ReaperSlacks() : CustomLeggings(
		name = "Reaper Slacks",
		customModelData = 1,
		description = listOf("Hide your", "unholy presence"),
		levelRequirement = 40,
		material = Material.LEATHER_LEGGINGS,
		baseStats = CustomItemUtils.statMap(
				health = 75.0,
				strength = 72.0,
				defense = -40.0,
				luck = -25.0,
		                                   ),
		leatherColor = Color.BLACK
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