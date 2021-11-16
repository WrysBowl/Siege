package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BoneHelmet() : CustomHelmet(
		name = "Bone Helmet",
		customModelData = 1,
		description = listOf("A second skull"),
		levelRequirement = 23,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 20.0, toughness = 60.0),
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