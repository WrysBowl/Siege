package net.siegerpg.siege.core.items.implemented.armor.boots.boneBoots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongBoneBoots() : CustomBoots(
		name = "Strong Bone Boots",
		customModelData = 1,
		description = listOf("Clunky footpads"),
		levelRequirement = 32,
		material = Material.LEATHER_BOOTS,
		baseStats = CustomItemUtils.statMap(health = 5.0, defense = 35.0, strength = 39.0),
		leatherColor = Color.GRAY,
		gearSetInfo = listOf(listOf("Deal +40 more strength"))
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