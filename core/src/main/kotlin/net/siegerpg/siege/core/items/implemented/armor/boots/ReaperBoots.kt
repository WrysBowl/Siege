package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ReaperBoots() : CustomBoots(
		name = "Reaper Boots",
		customModelData = 1,
		description = listOf("A step in the", "wrong direction"),
		levelRequirement = 39,
		material = Material.LEATHER_BOOTS,
		baseStats = CustomItemUtils.statMap(
				health = 80.0,
				strength = 78.0,
				defense = -10.0,
				luck = -10.0
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