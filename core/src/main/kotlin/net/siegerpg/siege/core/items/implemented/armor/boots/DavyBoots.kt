package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class DavyBoots() : CustomBoots(
	name = "Davy's Boots",
	customModelData = 1,
	description = listOf("Davy Jones is the fifth guardian"),
	levelRequirement = 33,
	material = Material.LEATHER_LEGGINGS,
	baseStats = CustomItemUtils.statMap(health = 90.0, strength = 25.0, regeneration = 35.0),
	gearSetInfo = listOf(listOf("Dolphin's Grace II, Speed I, Water breathing II")),
	leatherColor = Color.fromRGB(74, 104, 150)
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