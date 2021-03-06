package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BoneBoots() : CustomBoots(
		name = "Bone Boots",
		customModelData = 1,
		description = listOf("Clunky footpads"),
		levelRequirement = 23,
		material = Material.LEATHER_BOOTS,
		baseStats = CustomItemUtils.statMap(health = 10.0, defense = 37.0, regeneration = 15.0),
		leatherColor = Color.GRAY
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