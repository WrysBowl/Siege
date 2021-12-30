package net.siegerpg.siege.core.items.implemented.armor.chestplate.boneChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongBoneChestplate() : CustomChestplate(
		name = "Strong Bone Chestplate",
		customModelData = 1,
		description = listOf("Spare ribs"),
		levelRequirement = 24,
		material = Material.LEATHER_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 20.0, defense = 20.0, strength = 37.0),
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