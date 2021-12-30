package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ReaperCloak() : CustomChestplate(
		name = "Reaper Cloak",
		customModelData = 1,
		description = listOf("As dark as", "the night"),
		levelRequirement = 40,
		material = Material.LEATHER_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(
				health = 80.0,
				strength = 35.0,
				regeneration = 20.0,
				defense = -90.0,
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