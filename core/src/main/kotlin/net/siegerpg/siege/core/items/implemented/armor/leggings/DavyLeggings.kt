package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class DavyLeggings() : CustomLeggings(
		name = "Davy's Leggings",
		customModelData = 1,
		description = listOf("Davy Jones is the fifth guardian"),
		levelRequirement = 33,
		material = Material.LEATHER_LEGGINGS,
		baseStats = CustomItemUtils.statMap(health = 120.0, strength = 25.0, luck = 35.0, defense = -30.0),
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